package cn.controller;

import cn.pojo.Orders;
import cn.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Secured("ROLE_ADMIN")
    //查询订单列表
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> list = ordersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }
    //查询订单详情
    @RequestMapping("/findById")
    public ModelAndView dindById(@RequestParam(name = "id",required = true)String orderid)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersService.findById(orderid);
        modelAndView.setViewName("orders-show");
        modelAndView.addObject("orders",orders);
        return modelAndView;
    }

}
