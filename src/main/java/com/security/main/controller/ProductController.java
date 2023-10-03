package com.security.main.controller;

import com.security.main.dto.Product;
import com.security.main.entity.UserInfo;
import com.security.main.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/mypage")
    public String getMe(){

        return "HELLO! WELCOME TO MY WEBSITE..";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllProducts(){

        return service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product getById(@PathVariable int id){

        return service.getProduct(id);
    }

    @PostMapping("/new")
    public String addUser(@RequestBody UserInfo userInfo){

       return service.addUser(userInfo);

    }


}
