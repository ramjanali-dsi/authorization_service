package com.dsi.authorization.service;

import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.model.User;

/**
 * Created by sabbir on 6/24/16.
 */
public interface UserService {

    void saveUser(User user) throws CustomException;

    void updateUser(User user) throws CustomException;

    void deleteUser(User user) throws CustomException;

    User getUserByID(String userID) throws CustomException;
}
