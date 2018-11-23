package com.hhxk.assessment.repository;


import com.hhxk.assessment.entity.service.Examination;
import com.hhxk.assessment.entity.service.SubmitRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmitRecordRepository extends JpaRepository<SubmitRecord, Integer> {
}