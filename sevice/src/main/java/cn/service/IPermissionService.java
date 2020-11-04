package cn.service;

import cn.pojo.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission>findAll();

    void save(Permission permission);
}
