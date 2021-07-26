package com.vchoi.springboot.repository;

import com.vchoi.springboot.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends JpaRepository <CategoryEntity, Long>{

    CategoryEntity findOneByCode(String Code);
}
