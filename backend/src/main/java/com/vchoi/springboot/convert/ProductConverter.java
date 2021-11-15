package com.vchoi.springboot.convert;

import com.vchoi.springboot.dto.ProductDTO;
import com.vchoi.springboot.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductEntity toProductEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setTitle(productDTO.getTitle());
        productEntity.setContent(productDTO.getContent());
        productEntity.setShortDescription(productDTO.getShortDescription());
        productEntity.setThumbnail(productDTO.getThumbnail());
        return productEntity;
    }

    public ProductDTO toProductDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setTitle(productEntity.getTitle());
        productDTO.setContent(productEntity.getContent());
        productDTO.setShortDescription(productEntity.getShortDescription());
        productDTO.setThumbnail(productEntity.getThumbnail());
        productDTO.setCategoryCode(productEntity.getCategory().getCode());
        return productDTO;
    }

    public ProductEntity toProductEntity(ProductDTO productDTO, ProductEntity productEntity) {
        productEntity.setTitle(productDTO.getTitle());
        productEntity.setContent(productDTO.getContent());
        productEntity.setShortDescription(productDTO.getShortDescription());
        productEntity.setThumbnail(productDTO.getThumbnail());
        return productEntity;
    }


}
