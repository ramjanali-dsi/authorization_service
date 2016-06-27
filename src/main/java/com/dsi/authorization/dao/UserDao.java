package com.dsi.authorization.dao;

import com.dsi.authorization.model.User;

/**
 * Created by sabbir on 6/24/16.
 */
public interface UserDao {

    boolean saveUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(User user);

    User getUserByID(String userID);

    User getUserByEmail(String email);
}
