package cn.service.impl;

import cn.dao.RoleDao;
import cn.pojo.Permission;
import cn.pojo.Role;
import cn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
roleDao.save(role);
    }

    @Override
    public List<Permission> findByRoleIdOtherPermission(String id) {
        return roleDao.findByRoleIdOtherPermission(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
