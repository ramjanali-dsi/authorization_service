package com.dsi.authorization.dao;

import com.dsi.authorization.model.UserRole;

import java.util.List;

/**
 * Created by sabbir on 6/24/16.
 */
public interface UserRoleDao {

    boolean saveUserRole(UserRole userRole);
    boolean updateUserRole(UserRole userRole);
    boolean deleteUserRole(UserRole userRole);
    UserRole getUserRoleByIdOrRoleID(String userRoleID, String roleID);
    UserRole getUserRoleByUserIdAndSystemIdAndRoleID
            (String userID, String systemID, String roleID);
    UserRole getUserRoleByUserID(String userID);
    List<UserRole> getUserRoleListBySystemID(String systemID);
}
