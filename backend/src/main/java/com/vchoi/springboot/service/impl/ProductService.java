package com.vchoi.springboot.service.impl;

import com.vchoi.springboot.convert.ProductConverter;
import com.vchoi.springboot.dto.ProductDTO;
import com.vchoi.springboot.entity.CategoryEntity;
import com.vchoi.springboot.entity.ProductEntity;
import com.vchoi.springboot.repository.CategoryRepository;
import com.vchoi.springboot.repository.ProductRepository;
import com.vchoi.springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(productDTO.getCategoryCode());
        ProductEntity productEntity = productConverter.toProductEntity(productDTO);
        productEntity.setCategory(categoryEntity);
        productEntity = productRepository.save(productEntity);

        return productConverter.toProductDTO(productEntity);
    }
}
