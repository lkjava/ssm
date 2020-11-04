package cn.service;

import cn.pojo.Role;
import cn.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo finById(String id);

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] roles);
}
