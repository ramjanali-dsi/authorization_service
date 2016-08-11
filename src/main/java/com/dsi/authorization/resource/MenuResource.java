package com.dsi.authorization.resource;

import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.model.Menu;
import com.dsi.authorization.service.MenuService;
import com.dsi.authorization.service.impl.MenuServiceImpl;
import com.dsi.authorization.util.Utility;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabbir on 8/10/16.
 */

@Path("/v1/menu")
@Api(value = "/Menu", description = "Operations about Menu")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class MenuResource {

    private static final Logger logger = Logger.getLogger(MenuResource.class);

    private static final MenuService menuService = new MenuServiceImpl();

    @Context
    HttpServletRequest request;

    @GET
    @ApiOperation(value = "Read All Menus", notes = "Read All Menus", position = 4)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Read menus success"),
            @ApiResponse(code = 500, message = "Read menus failed, unauthorized.")
    })
    public Response getAllMenus() throws CustomException {
        String userID = request.getAttribute("user_id") != null ?
                request.getAttribute("user_id").toString() : null;

        List<Menu> menuList = menuService.getAllMenus(userID);
        logger.info("Menu list size: " + menuList.size());

        for(Menu menu : menuList){
            List<Menu> subMenu = menuService.getAllSubMenus(menu.getMenuId());
            if(!Utility.isNullOrEmpty(subMenu)){
                menu.setSubMenuList(subMenu);
            }
        }

        return Response.ok().entity(menuList).build();
    }
}
