package com.vchoi.springboot.repository;

import com.vchoi.springboot.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


}
