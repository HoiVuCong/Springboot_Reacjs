package com.vchoi.springboot.jwt;

import com.vchoi.springboot.entity.User;
import com.vchoi.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        User user = userRepository.findUserByUserName(userName);
        User user = User
                .builder()
                .userName("hoivc")
                .birthday(new Date())
                .createdBy("vc")
                .createdDate(new Date())
                .email("vvvv")
                .fullName("vchoi")
                .gender("dd")
                .build();
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new UserDetailsImpl(user);
    }
}
