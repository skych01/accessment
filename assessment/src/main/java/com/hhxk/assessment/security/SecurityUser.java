package com.hhxk.assessment.security;



import com.hhxk.assessment.entity.base.SysRole;
import com.hhxk.assessment.entity.base.SysUser;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityUser extends SysUser implements UserDetails {

    public SecurityUser() {
        super();
    }

    public SecurityUser(SysUser dUser) {
        BeanUtils.copyProperties(dUser, this);
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.isExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return  super.isEnabled();
    }

    @Override
    public String getUsername() {
        return  super.getUsername();
    }

    @Override
    public String getPassword() {
        return  super.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        List<SysRole> roles = this.getRoles();
        for (SysRole role:roles) {
            auths.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return auths;
    }
}
