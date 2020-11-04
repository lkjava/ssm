package cn.dao;

import cn.pojo.Member;
import cn.pojo.Orders;
import cn.pojo.Product;
import org.apache.ibatis.annotations.*;

import javax.tools.JavaCompiler;
import java.util.List;

public interface OrdersDao {
//查询全部订单
    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select =
                    "cn.dao.IProductDao.findById")),
            @Result(column = "member",property = "MEMBERID",javaType = Member.class,one = @One(select =
                    "cn.dao.MemberDao.findById")),
    })
    List<Orders>findAll()throws Exception;

//查询订单详情
    @Select("select * from orders where id=#{orderId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "PRODUCTID", javaType = Product.class,one = @One(select = "cn.dao.IProductDao.findById")),
            @Result(property = "member",column = "MEMBERID", javaType = Member.class,one = @One(select = "cn.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id", javaType = java.util.List.class,many = @Many(select = "cn.dao.TravellerDao.findByOrderId")),
    })
    Orders findByOrderId(String orderId)throws Exception;
}
