package com.dsi.authorization.dao.impl;

import com.dsi.authorization.dao.UserRoleDao;
import com.dsi.authorization.model.User;
import com.dsi.authorization.model.UserRole;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by sabbir on 6/24/16.
 */
public class UserRoleDaoImpl extends BaseDao implements UserRoleDao {

    private static final Logger logger = Logger.getLogger(UserRoleDaoImpl.class);

    @Override
    public boolean saveUserRole(UserRole userRole) {
        return save(userRole);
    }

    @Override
    public boolean updateUserRole(UserRole userRole) {
        return update(userRole);
    }

    @Override
    public boolean deleteUserRole(UserRole userRole) {
        return delete(userRole);
    }

    @Override
    public UserRole getUserRoleByIdOrRoleID(String userRoleID, String roleID) {
        Session session = null;
        UserRole userRole = null;
        Query query;
        try {
            session = getSession();
            if(userRoleID != null) {
                query = session.createQuery("FROM UserRole ur WHERE ur.userRoleId =:userRoleID");
                query.setParameter("userRoleID", userRoleID);

            } else {
                query = session.createQuery("FROM UserRole ur WHERE ur.role.roleId =:roleID");
                query.setParameter("roleID", roleID);
            }
            userRole = (UserRole) query.uniqueResult();

        } catch (Exception e) {
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return userRole;
    }

    @Override
    public UserRole getUserRoleByUserIdAndSystemIdAndRoleID(String userID, String systemID, String roleID) {
        Session session = null;
        UserRole userRole = null;
        try {
            session = getSession();
            Query query = session.createQuery("FROM UserRole ur WHERE ur.user.id =:userID AND " +
                    "ur.system.id =:systemID AND ur.role.id =:roleID");

            query.setParameter("userID", userID);
            query.setParameter("roleID", roleID);
            query.setParameter("systemID", systemID);

            userRole = (UserRole) query.uniqueResult();

        } catch (Exception e) {
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return userRole;
    }

    @Override
    public List<UserRole> getUserRoleListBySystemID(String systemID) {
        Session session = null;
        List<UserRole> userRoleList = null;
        try {
            session = getSession();
            Query query = session.createQuery("FROM UserRole ur WHERE ur.system.id =:systemID");

            query.setParameter("systemID", systemID);

            userRoleList = query.list();

        } catch (Exception e) {
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return userRoleList;
    }
}
