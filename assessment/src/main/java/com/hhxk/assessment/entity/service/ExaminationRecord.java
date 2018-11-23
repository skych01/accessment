package com.hhxk.assessment.entity.service;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "EXAMINATION_RECORD")
public class ExaminationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "record_id")
    private int recordId;

    @Column(name = "examination_id")
    private int examinationId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "execute_time")
    private Date executeTime;

    @Column(name = "record_type")
    private boolean recordType;


    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int value) {
        recordId = value;
    }

    public int getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(int value) {
        examinationId = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        userId = value;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date value) {
        executeTime = value;
    }

    public boolean getRecordType() {
        return recordType;
    }

    public void setRecordType(boolean value) {
        recordType = value;
    }


}