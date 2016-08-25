package com.dsi.authorization.resource;

import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.exception.ErrorContext;
import com.dsi.authorization.exception.ErrorMessage;
import com.dsi.authorization.model.Role;
import com.dsi.authorization.model.User;
import com.dsi.authorization.model.UserRole;
import com.dsi.authorization.service.RoleService;
import com.dsi.authorization.service.UserRoleService;
import com.dsi.authorization.service.UserService;
import com.dsi.authorization.service.impl.APIProvider;
import com.dsi.authorization.service.impl.RoleServiceImpl;
import com.dsi.authorization.service.impl.UserRoleServiceImpl;
import com.dsi.authorization.service.impl.UserServiceImpl;
import com.dsi.authorization.util.Constants;
import com.dsi.authorization.util.Utility;
import com.dsi.httpclient.HttpClient;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sabbir on 6/24/16.
 */

@Path("/v1/user")
@Api(value = "/User", description = "Operations about User")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class UserResource {

    private static final Logger logger = Logger.getLogger(UserResource.class);

    private static final HttpClient httpClient = new HttpClient();
    private static final RoleService roleService = new RoleServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private static final UserRoleService userRoleService = new UserRoleServiceImpl();

    @POST
    @ApiOperation(value = "User Create With Role / Without Role", notes = "User Create With Role / Without Role", position = 1)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User create success"),
            @ApiResponse(code = 500, message = "User create failed, unauthorized.")
    })
    public Response createUser(User user) throws CustomException {
        JSONObject responseObj = new JSONObject();

        try{
            User currentUser = userService.getUserByID(user.getCreateBy());

            logger.info("User create:: Start");
            user.setTenantId(currentUser.getTenantId());
            userService.saveUser(user);
            logger.info("User create:: End");

            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(roleService.getRoleByID(user.getRoleId()));
            userRole.setSystem(userService.getSystemByUserID(user.getCreateBy()));

            userRoleService.saveUserRole(userRole);
            logger.info("User role create successfully.");

            responseObj.put("user_id", user.getUserId());
            responseObj.put(Constants.MESSAGE, "Create user success.");
            return Response.ok().entity(responseObj.toString()).build();

        } catch (JSONException je){
            ErrorContext errorContext = new ErrorContext(null, null, je.getMessage());
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0009,
                    Constants.AUTHORIZATION_SERVICE_0009_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @PUT
    @ApiOperation(value = "User Update", notes = "User Update", position = 2)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User update success"),
            @ApiResponse(code = 500, message = "User update failed, unauthorized.")
    })
    public Response updateUser(User user) throws CustomException {
        JSONObject responseObj = new JSONObject();

        try{
            userService.updateUser(user);
            logger.info("User update successfully.");

            responseObj.put(Constants.MESSAGE, "Update user success.");
            return Response.ok().entity(responseObj.toString()).build();

        } catch (JSONException je){
            ErrorContext errorContext = new ErrorContext(null, null, je.getMessage());
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0009,
                    Constants.AUTHORIZATION_SERVICE_0009_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @DELETE
    @Path("/{user_id}")
    @ApiOperation(value = "User Delete", notes = "User Delete", position = 3)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User delete success"),
            @ApiResponse(code = 500, message = "User delete failed, unauthorized.")
    })
    public Response deleteUser(@PathParam("user_id") String userID) throws CustomException {
        JSONObject responseObj = new JSONObject();

        try{
            User user = userService.getUserByID(userID);
            userService.deleteUser(user);
            logger.info("User delete successfully.");

            responseObj.put(Constants.MESSAGE, "Delete user success.");
            return Response.ok().entity(responseObj.toString()).build();

        } catch (JSONException je){
            ErrorContext errorContext = new ErrorContext(null, null, je.getMessage());
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0009,
                    Constants.AUTHORIZATION_SERVICE_0009_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }
}
