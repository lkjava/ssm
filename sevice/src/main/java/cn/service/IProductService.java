package cn.service;

import cn.pojo.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);
}
