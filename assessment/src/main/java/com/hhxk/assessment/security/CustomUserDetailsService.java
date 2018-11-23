package com.hhxk.assessment.security;


import com.hhxk.assessment.entity.base.SysUser;
import com.hhxk.assessment.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("账号%1$S不存在！", username));
        }
        UserDetails result = new SecurityUser(user);
        return result;
    }
}
