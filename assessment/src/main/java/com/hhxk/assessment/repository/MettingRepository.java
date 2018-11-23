package com.hhxk.assessment.repository;


import com.hhxk.assessment.entity.service.Examination;
import com.hhxk.assessment.entity.service.Metting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MettingRepository extends JpaRepository<Metting, Integer> {
}