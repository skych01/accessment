package com.hhxk.assessment.repository;


import com.hhxk.assessment.entity.service.Examination;
import com.hhxk.assessment.entity.service.ExaminationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRecordRepository extends JpaRepository<ExaminationRecord, Integer> {
}