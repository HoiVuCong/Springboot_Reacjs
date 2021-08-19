package com.vchoi.springboot.service;

import com.vchoi.springboot.dto.ProductDTO;

public interface IProductService {

    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);

}
