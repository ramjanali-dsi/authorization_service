package com.dsi.authorization.service;

import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.model.UserSession;

/**
 * Created by sabbir on 7/11/16.
 */
public interface UserSessionService {

    void saveUserSession(UserSession userSession) throws CustomException;
    void updateUserSession(UserSession userSession) throws CustomException;
    void deleteUserSession(UserSession userSession) throws CustomException;
    UserSession getUserSessionByUserIdAndAccessToken(String userID, String accessToken) throws CustomException;
}
