package com.hhxk.assessment.repository;


import com.hhxk.assessment.entity.service.ExaminationRecord;
import com.hhxk.assessment.entity.service.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {
}