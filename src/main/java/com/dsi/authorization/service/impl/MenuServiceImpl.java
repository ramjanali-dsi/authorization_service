package com.dsi.authorization.service.impl;

import com.dsi.authorization.dao.MenuDao;
import com.dsi.authorization.dao.impl.MenuDaoImpl;
import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.exception.ErrorContext;
import com.dsi.authorization.exception.ErrorMessage;
import com.dsi.authorization.model.Menu;
import com.dsi.authorization.service.MenuService;
import com.dsi.authorization.util.Constants;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by sabbir on 8/10/16.
 */
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = Logger.getLogger(MenuServiceImpl.class);

    private static final MenuDao menuDao = new MenuDaoImpl();

    @Override
    public void saveMenu(Menu menu) throws CustomException {
        validateInputForCreation(menu);

        boolean res = menuDao.saveMenu(menu);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "Menu", "Menu create failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0002,
                    Constants.AUTHORIZATION_SERVICE_0002_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        logger.info("Menu save success.");
    }

    private void validateInputForCreation(Menu menu) throws CustomException {
        if(menu.getName() == null){
            ErrorContext errorContext = new ErrorContext(null, "Menu", "Menu Name not defined.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0001,
                    Constants.AUTHORIZATION_SERVICE_0001_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }

        if(menuDao.getMenuByIdOrName(null, menu.getName()) != null){
            ErrorContext errorContext = new ErrorContext(menu.getName(), "Menu", "Menu already exist by this name.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0002,
                    Constants.AUTHORIZATION_SERVICE_0002_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public void updateMenu(Menu menu) throws CustomException {
        boolean res = menuDao.updateMenu(menu);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "Menu", "Menu update failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0003,
                    Constants.AUTHORIZATION_SERVICE_0003_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        logger.info("Menu update success.");
    }

    @Override
    public void deleteMenu(Menu menu) throws CustomException {
        boolean res = menuDao.deleteMenu(menu);
        if(!res){
            ErrorContext errorContext = new ErrorContext(null, "Menu", "Menu delete failed.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0003,
                    Constants.AUTHORIZATION_SERVICE_0003_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        logger.info("Menu delete success.");
    }

    @Override
    public List<Menu> getAllSubMenus(String menuID) throws CustomException {
        List<Menu> subMenuList = menuDao.getAllSubMenus(menuID);
        if(subMenuList == null){
            ErrorContext errorContext = new ErrorContext(null, "Menu", "Menu list not found.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        return subMenuList;
    }

    @Override
    public List<Menu> getAllMenus(String userID) throws CustomException {
        List<Menu> menuList = menuDao.getAllMenus(userID);
        if(menuList == null){
            ErrorContext errorContext = new ErrorContext(null, "Menu", "Menu list not found.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        return menuList;
    }
}
