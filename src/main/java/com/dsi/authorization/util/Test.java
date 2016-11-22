package com.dsi.authorization.util;

import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.model.Menu;
import com.dsi.authorization.resource.MenuResource;
import com.dsi.authorization.service.MenuService;
import com.dsi.authorization.service.impl.MenuServiceImpl;
import com.google.gson.Gson;

/**
 * Created by sabbir on 11/15/16.
 */
public class Test {

    public static void main(String [] args) throws CustomException {
        MenuService menuService = new MenuServiceImpl();
        //System.out.println(new Gson().toJson(menuService.getAllMenus("f9e9a19f-4859-4e8c-a8f4-dc134629a57b")));

        Menu menu = new Menu();
        menu.setActive(true);
        menu.setDescription("Nothing");
        menu.setName("Leaves");

        menuService.saveMenu(menu);
    }
}
