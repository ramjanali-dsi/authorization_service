package com.dsi.authorization.service.impl;


import com.dsi.authorization.dao.UserSessionDao;
import com.dsi.authorization.dao.impl.UserSessionDaoImpl;
import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.exception.ErrorContext;
import com.dsi.authorization.exception.ErrorMessage;
import com.dsi.authorization.model.UserSession;
import com.dsi.authorization.service.UserSessionService;
import com.dsi.authorization.util.Constants;

/**
 * Created by sabbir on 6/15/16.
 */
public class UserSessionServiceImpl implements UserSessionService {

    private static final UserSessionDao dao = new UserSessionDaoImpl();

    @Override
    public void saveUserSession(UserSession userSession) throws CustomException {
        validateInputForCreation(userSession);

        boolean res = dao.saveUserSession(userSession);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "UserSession", "User session create failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0002,
                    Constants.AUTHORIZATION_SERVICE_0002_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    private void validateInputForCreation(UserSession userSession) throws CustomException {
        if(userSession.getAccessToken() == null){
            ErrorContext errorContext = new ErrorContext("AccessToken", "UserSession", "AccessToken not defined.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0001,
                    Constants.AUTHORIZATION_SERVICE_0001_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        if(userSession.getUserId() == null){
            ErrorContext errorContext = new ErrorContext("UserID", "UserSession", "UserID not defined.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0001,
                    Constants.AUTHORIZATION_SERVICE_0001_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public void updateUserSession(UserSession userSession) throws CustomException{
        boolean res = dao.updateUserSession(userSession);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "UserSession", "User session update failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0003,
                    Constants.AUTHORIZATION_SERVICE_0003_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public void deleteUserSession(UserSession userSession) throws CustomException{
        boolean res = dao.deleteUserSession(userSession);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "UserSession", "User session delete failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0004,
                    Constants.AUTHORIZATION_SERVICE_0004_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public UserSession getUserSessionByUserIdAndAccessToken(String userID, String accessToken) throws CustomException {
        UserSession userSession = dao.getUserSessionByUserIdAndAccessToken(userID, accessToken);
        if(userSession == null){
            ErrorContext errorContext = new ErrorContext(null, "UserSession", "User session not found by userID: "
                    + userID +" & accessToken: "+ accessToken);
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        return userSession;
    }
}
