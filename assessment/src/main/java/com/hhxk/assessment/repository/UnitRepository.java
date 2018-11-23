package com.hhxk.assessment.repository;


import com.hhxk.assessment.entity.service.ExaminationRecord;
import com.hhxk.assessment.entity.service.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
}