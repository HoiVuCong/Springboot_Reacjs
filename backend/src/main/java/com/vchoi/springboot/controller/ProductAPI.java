package com.vchoi.springboot.controller;

import com.vchoi.springboot.dto.ProductDTO;
import com.vchoi.springboot.service.IProductService;
import com.vchoi.springboot.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductAPI {

    @Autowired
    private IProductService productService;

    @PostMapping(name = "/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }


}
