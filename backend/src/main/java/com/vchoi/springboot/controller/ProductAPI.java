package com.vchoi.springboot.controller;

import com.vchoi.springboot.dto.ProductDTO;
import com.vchoi.springboot.exceptionhandler.TeacherNotFoundException;
import com.vchoi.springboot.repository.ProductRepository;
import com.vchoi.springboot.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductAPI {

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Operation(summary = "Creat a Product")
    @PostMapping(value = "/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PutMapping(value = "/product/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO,
                                    @PathVariable("id") long id) {
        var productEntity = productRepository.findById(id);
        if (productEntity.isPresent()) {
            throw new TeacherNotFoundException(productEntity.get().getTitle() + "  not found");
        }
        productDTO.setId(id);
        return productService.update(productDTO);
    }

}
