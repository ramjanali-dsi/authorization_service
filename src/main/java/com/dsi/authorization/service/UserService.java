package com.dsi.authorization.service;

import com.dsi.authorization.dto.UserDto;
import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.model.System;
import com.dsi.authorization.model.User;

import java.util.List;

/**
 * Created by sabbir on 6/24/16.
 */
public interface UserService {

    void saveUser(User user) throws CustomException;
    void updateUser(User user) throws CustomException;
    void deleteUser(String userID) throws CustomException;
    User getUserByID(String userID) throws CustomException;
    List<UserDto> getAllUserByRole(String roleType) throws CustomException;
    List<String> getUsersByRoleType(String roleType) throws CustomException;
    System getSystemByUserID(String userID) throws CustomException;
}
