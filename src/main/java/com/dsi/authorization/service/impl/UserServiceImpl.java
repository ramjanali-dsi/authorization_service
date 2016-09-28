package com.dsi.authorization.service.impl;

import com.dsi.authorization.dao.UserDao;
import com.dsi.authorization.dao.UserRoleDao;
import com.dsi.authorization.dao.UserSessionDao;
import com.dsi.authorization.dao.impl.UserDaoImpl;
import com.dsi.authorization.dao.impl.UserRoleDaoImpl;
import com.dsi.authorization.dao.impl.UserSessionDaoImpl;
import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.exception.ErrorContext;
import com.dsi.authorization.exception.ErrorMessage;
import com.dsi.authorization.model.System;
import com.dsi.authorization.model.User;
import com.dsi.authorization.service.UserService;
import com.dsi.authorization.util.Constants;
import com.dsi.authorization.util.Utility;

/**
 * Created by sabbir on 6/24/16.
 */
public class UserServiceImpl implements UserService {

    private static final UserDao userDao = new UserDaoImpl();

    @Override
    public void saveUser(User user) throws CustomException {
        validateInputForCreation(user);

        user.setCreatedDate(Utility.today());
        user.setModifiedDate(Utility.today());
        boolean res = userDao.saveUser(user);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "User", "User create failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0002,
                    Constants.AUTHORIZATION_SERVICE_0002_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    private void validateInputForCreation(User user) throws CustomException {
        if(user.getTenantId() == null){
            ErrorContext errorContext = new ErrorContext(null, "User", "TenantID not defined.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0001,
                    Constants.AUTHORIZATION_SERVICE_0001_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }

        if(userDao.getUserByEmail(user.getEmail()) != null){
            ErrorContext errorContext = new ErrorContext(null, "User", "User already exist.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0002,
                    Constants.AUTHORIZATION_SERVICE_0002_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public void updateUser(User user) throws CustomException {
        user.setCreatedDate(Utility.today());
        user.setModifiedDate(Utility.today());

        boolean res = userDao.updateUser(user);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "User", "User update failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0003,
                    Constants.AUTHORIZATION_SERVICE_0003_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public void deleteUser(User user) throws CustomException {

        userDao.deleteUserSession(user.getUserId());
        userDao.deleteUserRole(user.getUserId());

        boolean res = userDao.deleteUser(user);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "User", "User delete failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0004,
                    Constants.AUTHORIZATION_SERVICE_0004_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public User getUserByID(String userID) throws CustomException {
        User user = userDao.getUserByID(userID);
        if (user == null) {
            ErrorContext errorContext = new ErrorContext(userID, "User", "User not found by userID: " + userID);
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        return user;
    }

    @Override
    public System getSystemByUserID(String userID) throws CustomException {
        System system = userDao.getSystemByUserID(userID);
        if (system == null) {
            ErrorContext errorContext = new ErrorContext(userID, "System", "System not found by userID: " + userID);
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        return system;
    }
}
