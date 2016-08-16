package com.dsi.authorization.dao.impl;

import com.dsi.authorization.dao.UserDao;
import com.dsi.authorization.model.System;
import com.dsi.authorization.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by sabbir on 6/24/16.
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public boolean saveUser(User user) {
        return save(user);
    }

    @Override
    public boolean updateUser(User user) {
        return update(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return delete(user);
    }

    @Override
    public User getUserByID(String userID) {
        Session session = null;
        User user = null;
        try {
            session = getSession();
            Query query = session.createQuery("FROM User u WHERE u.userId =:userID");
            query.setParameter("userID", userID);

            user = (User) query.uniqueResult();

        } catch (Exception e) {
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        Session session = null;
        User user = null;
        try {
            session = getSession();
            Query query = session.createQuery("FROM User u WHERE u.email =:email");
            query.setParameter("email", email);

            user = (User) query.uniqueResult();

        } catch (Exception e) {
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return user;
    }

    @Override
    public System getSystemByUserID(String userID) {
        Session session = null;
        System system = null;
        try {
            session = getSession();
            Query query = session.createQuery("FROM System s WHERE s.tenantId in " +
                    "(SELECT u.tenantId FROM User u WHERE u.userId =:userID)");
            query.setParameter("userID", userID);

            system = (System) query.uniqueResult();

        } catch (Exception e) {
            logger.error("Database error occurs when get: " + e.getMessage());
        } finally {
            if(session != null) {
                close(session);
            }
        }
        return system;
    }
}
