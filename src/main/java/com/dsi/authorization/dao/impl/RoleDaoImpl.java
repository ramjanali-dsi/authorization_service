package com.dsi.authorization.dao.impl;

import com.dsi.authorization.dao.RoleDao;
import com.dsi.authorization.model.Role;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by sabbir on 6/27/16.
 */
public class RoleDaoImpl extends BaseDao implements RoleDao {

    private static final Logger logger = Logger.getLogger(RoleDaoImpl.class);

    @Override
    public boolean saveRole(Role role) {
        return save(role);
    }

    @Override
    public boolean updateRole(Role role) {
        return update(role);
    }

    @Override
    public boolean deleteRole(Role role) {
        return delete(role);
    }

    @Override
    public Role getRoleByID(String roleID) {
        Session session = null;
        Role role = null;
        try{
            session = getSession();
            Query query = session.createQuery("FROM Role r WHERE r.roleId =:roleID");
            query.setParameter("roleID", roleID);

            role = (Role) query.uniqueResult();

        } catch (Exception e) {
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return role;
    }

    @Override
    public Role getRoleByName(String roleName) {
        Session session = null;
        Role role = null;
        try{
            session = getSession();
            Query query = session.createQuery("FROM Role r WHERE r.name =:roleName");
            query.setParameter("roleName", roleName);

            role = (Role) query.uniqueResult();

        } catch (Exception e) {
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        Session session = null;
        List<Role> roleList = null;
        try {
            session = getSession();
            Query query = session.createQuery("FROM Role");

            roleList = query.list();

        } catch (Exception e) {
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return roleList;
    }
}
