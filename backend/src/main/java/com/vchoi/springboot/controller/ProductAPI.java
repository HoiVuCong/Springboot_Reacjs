package com.vchoi.springboot.controller;

import com.vchoi.springboot.dto.ProductDTO;
import com.vchoi.springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductAPI {

    @Autowired
    private IProductService productService;

    @PostMapping(value = "/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PutMapping(value = "/product/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO,
                                    @PathVariable("id") long id) {
        productDTO.setId(id);

        return productService.update(productDTO);
    }

}
