package com.dsi.authorization.resource;

import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.exception.ErrorContext;
import com.dsi.authorization.exception.ErrorMessage;
import com.dsi.authorization.model.User;
import com.dsi.authorization.model.UserSession;
import com.dsi.authorization.service.UserSessionService;
import com.dsi.authorization.service.impl.UserSessionServiceImpl;
import com.dsi.authorization.util.Constants;
import com.dsi.authorization.util.Utility;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sabbir on 7/11/16.
 */

@Path("/v1/user_session")
@Api(value = "/UserSession", description = "Operations about UserSession")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class UserSessionResource {

    private static final Logger logger = Logger.getLogger(UserSessionResource.class);

    private static final UserSessionService userSessionService = new UserSessionServiceImpl();

    @POST
    @ApiOperation(value = "User Session Create", notes = "User Session Create", position = 1)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User session create success"),
            @ApiResponse(code = 500, message = "User session create failed, unauthorized.")
    })
    public Response createUserSession(UserSession userSession) throws CustomException {
        JSONObject responseObj = new JSONObject();

        try{
            logger.info("Access Token: " + userSession.getAccessToken());

            userSession.setCreatedDate(Utility.today());
            userSession.setModifiedDate(Utility.today());
            userSession.setVersion(1);

            userSessionService.saveUserSession(userSession);
            logger.info("User session save success.");

            responseObj.put(Constants.MESSAGE, "Create user session success.");
            return Response.ok().entity(responseObj.toString()).build();

        } catch (JSONException je){
            ErrorContext errorContext = new ErrorContext(null, null, je.getMessage());
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0009,
                    Constants.AUTHORIZATION_SERVICE_0009_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }
}
