package cn.service;

import cn.pojo.Permission;
import cn.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    List<Permission> findByRoleIdOtherPermission(String id);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
