package cn.controller;

import cn.pojo.Role;
import cn.pojo.UserInfo;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    //用户关联角色操作-添加角色
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true)String[] roles){
        userService.addRoleToUser(userId,roles);
        return "redirect:findAll.do";
    }

    //用户关联角色操作
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView  findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId ){

        UserInfo  userInfo = userService.finById(userId);
        //根据用户id查询出 没有的角色
        List<Role>  roleList =   userService.findOtherRoles(userId);

        ModelAndView  mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;

    }

//查询用户详情
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        UserInfo userInfo = userService.finById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @PreAuthorize("authentication.principal.username=='xiaohei'")
    //查询全部
    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<UserInfo> userInfoList = userService.findAll();
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("userList",userInfoList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
}
