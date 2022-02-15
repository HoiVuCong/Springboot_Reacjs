package com.vchoi.springboot.repository;

import com.vchoi.springboot.entity.ERole;
import com.vchoi.springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
