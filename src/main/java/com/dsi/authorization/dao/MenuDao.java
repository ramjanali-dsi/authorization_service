package com.dsi.authorization.dao;

import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.model.Menu;

import java.util.List;

/**
 * Created by sabbir on 8/10/16.
 */
public interface MenuDao {

    boolean saveMenu(Menu menu);

    boolean updateMenu(Menu menu);

    boolean deleteMenu(Menu menu);

    Menu getMenuByIdOrName(String menuID, String name);

    List<Menu> getAllSubMenus(String menuID);

    List<Menu> getAllMenus();
}
