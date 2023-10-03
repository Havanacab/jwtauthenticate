package com.security.main.service;

import com.security.main.config.UserInfoUserDetails;
import com.security.main.entity.UserInfo;
import com.security.main.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Optional<UserInfo> userInfo = repository.findByName(username);
        return  userInfo.map(UserInfoUserDetails::new)
               .orElseThrow(()-> new UsernameNotFoundException("username not found "+ username));

    }
}
