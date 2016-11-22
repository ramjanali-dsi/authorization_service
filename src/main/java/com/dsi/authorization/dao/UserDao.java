package com.dsi.authorization.dao;

import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.model.System;
import com.dsi.authorization.model.User;
import org.hibernate.Session;

/**
 * Created by sabbir on 6/24/16.
 */
public interface UserDao {

    void setSession(Session session);
    void saveUser(User user) throws CustomException;
    void updateUser(User user) throws CustomException;
    void deleteUser(User user) throws CustomException;
    void deleteUserSession(String userID) throws CustomException;
    void deleteUserRole(String userID) throws CustomException;
    User getUserByID(String userID);
    User getUserByEmail(String email);
    System getSystemByUserID(String userID);
}
