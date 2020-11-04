package cn.controller;

import cn.pojo.Product;
import cn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @RolesAllowed("ADMIN")
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Product> list = productService.findAll();
        model.addAttribute("productList",list);
        return "product-list";
    }
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redrect:findAll.do";
    }
}
