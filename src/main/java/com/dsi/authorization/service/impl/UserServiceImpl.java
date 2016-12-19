package com.dsi.authorization.service.impl;

import com.dsi.authorization.dao.RoleDao;
import com.dsi.authorization.dao.UserDao;
import com.dsi.authorization.dao.UserRoleDao;
import com.dsi.authorization.dao.impl.RoleDaoImpl;
import com.dsi.authorization.dao.impl.UserDaoImpl;
import com.dsi.authorization.dao.impl.UserRoleDaoImpl;
import com.dsi.authorization.dto.UserDto;
import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.exception.ErrorContext;
import com.dsi.authorization.exception.ErrorMessage;
import com.dsi.authorization.model.System;
import com.dsi.authorization.model.User;
import com.dsi.authorization.model.UserRole;
import com.dsi.authorization.service.UserService;
import com.dsi.authorization.util.Constants;
import com.dsi.authorization.util.Utility;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabbir on 6/24/16.
 */
public class UserServiceImpl extends CommonService implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    private static final UserDao userDao = new UserDaoImpl();
    private static final RoleDao roleDao = new RoleDaoImpl();
    private static final UserRoleDao userRoleDao = new UserRoleDaoImpl();

    @Override
    public void saveUser(User user) throws CustomException {
        Session session = getSession();
        userDao.setSession(session);
        roleDao.setSession(session);
        userRoleDao.setSession(session);

        User currentUser = userDao.getUserByID(user.getCreateBy());
        user.setTenantId(currentUser.getTenantId());

        if(user.getTenantId() == null){
            close(session);
            ErrorContext errorContext = new ErrorContext(null, "User", "TenantID not defined.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0001,
                    Constants.AUTHORIZATION_SERVICE_0001_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }

        if(userDao.getUserByEmail(user.getEmail()) != null){
            close(session);
            ErrorContext errorContext = new ErrorContext(null, "User", "User already exist.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0002,
                    Constants.AUTHORIZATION_SERVICE_0002_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }

        user.setCreatedDate(Utility.today());
        user.setModifiedDate(Utility.today());
        userDao.saveUser(user);
        logger.info("User create successfully.");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(roleDao.getRoleByID(user.getRoleId()));
        userRole.setSystem(userDao.getSystemByUserID(user.getCreateBy()));
        userRole.setCreateBy(user.getCreateBy());
        userRole.setModifiedBy(user.getModifiedBy());
        userRole.setCreatedDate(Utility.today());
        userRole.setModifiedDate(Utility.today());
        userRole.setActive(true);
        userRole.setVersion(1);
        userRoleDao.saveUserRole(userRole);
        logger.info("User role create successfully.");

        close(session);
    }

    @Override
    public void updateUser(User user) throws CustomException {
        Session session = getSession();
        userDao.setSession(session);

        user.setCreatedDate(Utility.today());
        user.setModifiedDate(Utility.today());

        userDao.updateUser(user);

        close(session);
    }

    @Override
    public void deleteUser(String userID) throws CustomException {
        Session session = getSession();
        userDao.setSession(session);

        User user = userDao.getUserByID(userID);
        if(user != null) {
            userDao.deleteUserSession(user.getUserId());
            userDao.deleteUserRole(user.getUserId());
            userDao.deleteUser(user);
        }

        close(session);
    }

    @Override
    public User getUserByID(String userID) throws CustomException {
        Session session = getSession();
        userDao.setSession(session);

        User user = userDao.getUserByID(userID);
        if (user == null) {
            close(session);
            ErrorContext errorContext = new ErrorContext(userID, "User", "User not found by userID: " + userID);
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }

        close(session);
        return user;
    }

    @Override
    public List<UserDto> getAllUserByRole(String roleType) throws CustomException {

        Session session = getSession();
        userRoleDao.setSession(session);

        List<UserRole> userRoleList = userRoleDao.getAllUserByRole(roleType);
        if(userRoleList == null){
            close(session);
            ErrorContext errorContext = new ErrorContext(null, "UserRole", "User role list not found by roleType: " + roleType);
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        logger.info("User role list size: " + userRoleList.size());

        List<UserDto> userDtoList = new ArrayList<>();
        for(UserRole userRole : userRoleList){
            UserDto userDto = new UserDto();
            userDto.setUserId(userRole.getUser().getUserId());
            userDto.setFirstName(userRole.getUser().getFirstName());
            userDto.setLastName(userRole.getUser().getLastName());

            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    @Override
    public System getSystemByUserID(String userID) throws CustomException {
        Session session = getSession();
        userDao.setSession(session);

        System system = userDao.getSystemByUserID(userID);
        if (system == null) {
            close(session);
            ErrorContext errorContext = new ErrorContext(userID, "System", "System not found by userID: " + userID);
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }

        close(session);
        return system;
    }
}
