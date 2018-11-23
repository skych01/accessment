package com.hhxk.assessment.repository;


import com.hhxk.assessment.entity.base.SysResource;
import com.hhxk.assessment.entity.base.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysResourceRepository extends JpaRepository<SysResource, Integer> {
}