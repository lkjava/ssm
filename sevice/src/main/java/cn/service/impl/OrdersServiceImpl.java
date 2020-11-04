package cn.service.impl;

import cn.dao.OrdersDao;
import cn.pojo.Orders;
import cn.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    //查询全部订单
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }
    //查询订单详情

    @Override
    public Orders findById(String orderid) throws Exception{
        return ordersDao.findByOrderId(orderid);
    }
}
