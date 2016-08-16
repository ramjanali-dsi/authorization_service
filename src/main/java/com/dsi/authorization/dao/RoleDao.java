package com.dsi.authorization.dao;

import com.dsi.authorization.model.Role;

import java.util.List;

/**
 * Created by sabbir on 6/27/16.
 */
public interface RoleDao {

    boolean saveRole(Role role);
    boolean updateRole(Role role);
    boolean deleteRole(Role role);
    Role getRoleByID(String roleID);
    Role getRoleByName(String roleName);
    List<Role> getAllRoles();
}
