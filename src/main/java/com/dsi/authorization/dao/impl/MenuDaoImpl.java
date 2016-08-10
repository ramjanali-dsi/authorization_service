package com.dsi.authorization.dao.impl;

import com.dsi.authorization.dao.MenuDao;
import com.dsi.authorization.model.Menu;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by sabbir on 8/10/16.
 */
public class MenuDaoImpl extends BaseDao implements MenuDao {

    private static final Logger logger = Logger.getLogger(MenuDaoImpl.class);

    @Override
    public boolean saveMenu(Menu menu) {
        return save(menu);
    }

    @Override
    public boolean updateMenu(Menu menu) {
        return update(menu);
    }

    @Override
    public boolean deleteMenu(Menu menu) {
        return delete(menu);
    }

    @Override
    public Menu getMenuByIdOrName(String menuID, String name) {
        Session session = null;
        Menu menu = null;
        Query query;
        try{
            session = getSession();
            if(menuID != null){
                query = session.createQuery("FROM Menu m WHERE m.menuId =:menuID");
                query.setParameter("menuID", menuID);

            } else {
                query = session.createQuery("FROM Menu m WHERE m.name =:name");
                query.setParameter("name", name);
            }

            menu = (Menu) query.uniqueResult();

        } catch (Exception e){
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return menu;
    }

    @Override
    public List<Menu> getAllMenus() {
        Session session = null;
        List<Menu> menuList = null;
        try {
            session = getSession();
            Query query = session.createQuery("FROM Menu m ORDER BY m.position ASC");

            menuList = query.list();

        } catch (Exception e) {
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return menuList;
    }
}
