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
        System.out.println(new Gson().toJson(menuService.
                getAllMenusAndApiPermission("e4c23852-3a7a-447c-a6a0-ae370e7f041a")));
    }
}
