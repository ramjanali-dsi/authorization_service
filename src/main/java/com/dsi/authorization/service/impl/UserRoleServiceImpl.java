package com.dsi.authorization.service.impl;

import com.dsi.authorization.dao.UserRoleDao;
import com.dsi.authorization.dao.impl.UserRoleDaoImpl;
import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.exception.ErrorContext;
import com.dsi.authorization.exception.ErrorMessage;
import com.dsi.authorization.model.UserRole;
import com.dsi.authorization.service.UserRoleService;
import com.dsi.authorization.util.Constants;
import com.dsi.authorization.util.Utility;

import java.util.List;

/**
 * Created by sabbir on 6/24/16.
 */
public class UserRoleServiceImpl implements UserRoleService {

    private static final UserRoleDao userRoleDao = new UserRoleDaoImpl();

    @Override
    public void saveUserRole(UserRole userRole) throws CustomException {
        validateInputForCreation(userRole);

        UserRole isUserRoleExist = userRoleDao.getUserRoleByUserIdAndSystemIdAndRoleID
                (userRole.getUser().getUserId(), userRole.getSystem().getSystemId(), userRole.getRole().getRoleId());
        if(isUserRoleExist != null){
            ErrorContext errorContext = new ErrorContext(null, "UserRole", "User role already exist.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0002,
                    Constants.AUTHORIZATION_SERVICE_0002_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }

        userRole.setCreatedDate(Utility.today());
        userRole.setModifiedDate(Utility.today());

        boolean res = userRoleDao.saveUserRole(userRole);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "UserRole", "User role create failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0002,
                    Constants.AUTHORIZATION_SERVICE_0002_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    private void validateInputForCreation(UserRole userRole) throws CustomException {
        if(userRole.getRole().getRoleId() ==  null){
            ErrorContext errorContext = new ErrorContext("RoleID", "UserRole",
                    "RoleID not defined.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0001,
                    Constants.AUTHORIZATION_SERVICE_0001_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public void updateUserRole(UserRole userRole) throws CustomException {
        userRole.setCreatedDate(Utility.today());
        userRole.setModifiedDate(Utility.today());

        boolean res = userRoleDao.updateUserRole(userRole);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "UserRole", "User role update failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0003,
                    Constants.AUTHORIZATION_SERVICE_0003_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public void deleteUserRole(UserRole userRole) throws CustomException {
        boolean res = userRoleDao.deleteUserRole(userRole);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "UserRole", "User role delete failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0004,
                    Constants.AUTHORIZATION_SERVICE_0004_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public UserRole getUserRoleByID(String userRoleID) throws CustomException {
        UserRole userRole = userRoleDao.getUserRoleByID(userRoleID);
        if(userRole == null){
            ErrorContext errorContext = new ErrorContext(userRoleID, "UserRole", "User role not found by userRoleID: " + userRoleID);
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        return userRole;
    }

    @Override
    public List<UserRole> getUserRoleListBySystemID(String systemID) throws CustomException {
        List<UserRole> userRoleList = userRoleDao.getUserRoleListBySystemID(systemID);
        if(userRoleList == null){
            ErrorContext errorContext = new ErrorContext(systemID, "UserRole", "User role list not found by systemID: " + systemID);
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        return userRoleList;
    }
}
