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
import org.hibernate.Session;

import java.util.List;

/**
 * Created by sabbir on 8/10/16.
 */
public class MenuServiceImpl extends CommonService implements MenuService {

    private static final Logger logger = Logger.getLogger(MenuServiceImpl.class);

    private static final MenuDao menuDao = new MenuDaoImpl();

    @Override
    public void saveMenu(Menu menu) throws CustomException {
        Session session = getSession();
        menuDao.setSession(session);

        validateInputForCreation(menu, session);

        menuDao.saveMenu(menu);
        logger.info("Menu save success.");

        close(session);
    }

    private void validateInputForCreation(Menu menu, Session session) throws CustomException{
        if(menu.getName() == null){
            close(session);
            ErrorContext errorContext = new ErrorContext(null, "Menu", "Menu Name not defined.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0001,
                    Constants.AUTHORIZATION_SERVICE_0001_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }

        if(menuDao.getMenuByIdOrName(null, menu.getName()) != null){
            close(session);
            ErrorContext errorContext = new ErrorContext(menu.getName(), "Menu", "Menu already exist by this name.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0002,
                    Constants.AUTHORIZATION_SERVICE_0002_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public void updateMenu(Menu menu) throws CustomException {
        Session session = getSession();
        menuDao.setSession(session);

        menuDao.updateMenu(menu);
        logger.info("Menu update success.");

        close(session);
    }

    @Override
    public void deleteMenu(Menu menu) throws CustomException {
        Session session = getSession();
        menuDao.setSession(session);

        menuDao.deleteMenu(menu);
        logger.info("Menu delete success.");

        close(session);
    }

    @Override
    public List<Menu> getAllMenus(String userID) throws CustomException {
        Session session = getSession();
        menuDao.setSession(session);

        List<Menu> menuList = menuDao.getAllMenus(userID);
        if(menuList == null){
            close(session);
            ErrorContext errorContext = new ErrorContext(null, "Menu", "Menu list not found.");
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0005,
                    Constants.AUTHORIZATION_SERVICE_0005_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
        logger.info("Menu list size: " + menuList.size());

        for(Menu menu : menuList) {
            List<Menu> subMenuList = menuDao.getAllSubMenus(menu.getMenuId());
            logger.info("Sub menu list size: " + subMenuList.size());
            menu.setSubMenuList(subMenuList);
        }

        close(session);
        return menuList;
    }
}
