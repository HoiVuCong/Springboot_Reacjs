package com.vchoi.springboot.jwt;

import com.vchoi.springboot.entity.User;
import com.vchoi.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        User user = userRepository.findUserByUserName(userName);
        User user = new User() ;
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new UserDetailsImpl(user);
    }

}
