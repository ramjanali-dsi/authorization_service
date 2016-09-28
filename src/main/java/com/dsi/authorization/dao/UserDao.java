package com.dsi.authorization.dao;

import com.dsi.authorization.model.System;
import com.dsi.authorization.model.User;

/**
 * Created by sabbir on 6/24/16.
 */
public interface UserDao {

    boolean saveUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
    boolean deleteUserSession(String userID);
    boolean deleteUserRole(String userID);
    User getUserByID(String userID);
    User getUserByEmail(String email);
    System getSystemByUserID(String userID);
}
