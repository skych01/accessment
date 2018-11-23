package com.hhxk.assessment.entity.service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "SUBMIT_RECORD")
public class SubmitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "submit_id")
    private int submitId;

    @Column(name = "result")
    private boolean result;

    @Column(name = "examine_user_id")
    private int examineUserId;

    @Column(name = "submit_user_id")
    private int submitUserId;

    @Column(name = "submit_time")
    private Date submitTime;

/*    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "examination_submit_record",
            joinColumns = {@JoinColumn(name = "submitId", referencedColumnName = "submitId")},
            inverseJoinColumns = {@JoinColumn(name = "examinationId", referencedColumnName = "examinationId")}
    )
    private List<Examination> examinationList;*/


    public int getSubmitId() {
        return submitId;
    }

    public void setSubmitId(int value) {
        submitId = value;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean value) {
        result = value;
    }

    public int getExamineUserId() {
        return examineUserId;
    }

    public void setExamineUserId(int value) {
        examineUserId = value;
    }

    public int getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(int value) {
        submitUserId = value;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date value) {
        submitTime = value;
    }


}