package com.hhxk.assessment.repository;


import com.hhxk.assessment.entity.base.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Integer> {
    SysUser findByUsername(String username);
}