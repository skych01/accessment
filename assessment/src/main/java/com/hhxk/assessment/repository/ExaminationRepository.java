package com.hhxk.assessment.repository;


import com.hhxk.assessment.entity.service.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Integer> {
}