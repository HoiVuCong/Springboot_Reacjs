package com.vchoi.springboot.repository;

import com.vchoi.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String userName);

    Boolean existsByUserName(String userName);


}
