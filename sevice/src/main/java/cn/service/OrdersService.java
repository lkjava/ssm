package cn.service;

import cn.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll(int page,int size)throws Exception;

    Orders findById(String orderid) throws Exception;
}
