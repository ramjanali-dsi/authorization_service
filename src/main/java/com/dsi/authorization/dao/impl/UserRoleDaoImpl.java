package com.dsi.authorization.dao.impl;

import com.dsi.authorization.dao.UserRoleDao;
import com.dsi.authorization.exception.CustomException;
import com.dsi.authorization.exception.ErrorContext;
import com.dsi.authorization.exception.ErrorMessage;
import com.dsi.authorization.model.RoleName;
import com.dsi.authorization.model.UserRole;
import com.dsi.authorization.service.impl.CommonService;
import com.dsi.authorization.util.Constants;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by sabbir on 6/24/16.
 */
public class UserRoleDaoImpl extends CommonService implements UserRoleDao {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void saveUserRole(UserRole userRole) throws CustomException {
        try{
            session.save(userRole);

        } catch (Exception e){
            close(session);
            ErrorContext errorContext = new ErrorContext(null, "UserRole", e.getMessage());
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0002,
                    Constants.AUTHORIZATION_SERVICE_0002_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public void updateUserRole(UserRole userRole) throws CustomException {
        try{
            session.update(userRole);

        } catch (Exception e){
            close(session);
            ErrorContext errorContext = new ErrorContext(null, "UserRole", e.getMessage());
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0003,
                    Constants.AUTHORIZATION_SERVICE_0003_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public void deleteUserRole(UserRole userRole) throws CustomException {
        try{
            session.delete(userRole);

        } catch (Exception e){
            close(session);
            ErrorContext errorContext = new ErrorContext(null, "UserRole", e.getMessage());
            ErrorMessage errorMessage = new ErrorMessage(Constants.AUTHORIZATION_SERVICE_0004,
                    Constants.AUTHORIZATION_SERVICE_0004_DESCRIPTION, errorContext);
            throw new CustomException(errorMessage);
        }
    }

    @Override
    public UserRole getUserRoleByIdOrRoleID(String userRoleID, String roleID) {
        Query query;
        if(userRoleID != null) {
            query = session.createQuery("FROM UserRole ur WHERE ur.userRoleId =:userRoleID");
            query.setParameter("userRoleID", userRoleID);

        } else {
            query = session.createQuery("FROM UserRole ur WHERE ur.role.roleId =:roleID");
            query.setParameter("roleID", roleID);
        }

        UserRole userRole = (UserRole) query.uniqueResult();
        if(userRole != null) {
            return userRole;
        }
        return null;
    }

    @Override
    public UserRole getUserRoleByUserIdAndSystemIdAndRoleID(String userID, String systemID, String roleID) {
        Query query = session.createQuery("FROM UserRole ur WHERE ur.user.id =:userID AND " +
                "ur.system.id =:systemID AND ur.role.id =:roleID");

        query.setParameter("userID", userID);
        query.setParameter("roleID", roleID);
        query.setParameter("systemID", systemID);

        UserRole userRole = (UserRole) query.uniqueResult();
        if(userRole != null) {
            return userRole;
        }
        return null;
    }

    @Override
    public UserRole getUserRoleByUserID(String userID) {
        Query query = session.createQuery("FROM UserRole ur WHERE ur.user.id =:userID");
        query.setParameter("userID", userID);

        UserRole userRole = (UserRole) query.uniqueResult();
        if(userRole != null) {
            return userRole;
        }
        return null;
    }

    @Override
    public List<UserRole> getAllUserByRole(String roleType) {
        Query query;
        if(roleType != null) {
            query = session.createQuery("FROM UserRole ur WHERE ur.role.name =:roleName");
            query.setParameter("roleName", roleType);

        } else {
            query = session.createQuery("FROM UserRole ur WHERE ur.role.name =:roleType1 Or ur.role.name =:roleType2");
            query.setParameter("roleType1", RoleName.LEAD.getValue());
            query.setParameter("roleType2", RoleName.MEMBER.getValue());
        }

        List<UserRole> userRoleList = query.list();
        if(userRoleList != null){
            return userRoleList;
        }
        return null;
    }

    @Override
    public List<UserRole> getAllUserByRole() {
        Query query = session.createQuery("FROM UserRole ur WHERE ur.role.name =:roleName1 or ur.role.name =:roleName2");
        query.setParameter("roleName1", RoleName.HR.getValue());
        query.setParameter("roleName2", RoleName.MANAGER.getValue());

        List<UserRole> userRoleList = query.list();
        if(userRoleList != null){
            return userRoleList;
        }
        return null;
    }

    @Override
    public List<UserRole> getUserRoleListBySystemID(String systemID) {
        Query query = session.createQuery("FROM UserRole ur WHERE ur.system.id =:systemID");
        query.setParameter("systemID", systemID);

        List<UserRole> userRoleList = query.list();
        if(userRoleList != null){
            return userRoleList;
        }
        return null;
    }
}
