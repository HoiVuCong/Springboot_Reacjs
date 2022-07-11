package com.vchoi.springboot.repository;

import com.vchoi.springboot.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


}
