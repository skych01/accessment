package com.hhxk.assessment.entity.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "METTING")
public class Metting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "metting_id")
    private int mettingId;

    @Column(name = "name")
    private String name;

    @Column(name = "place")
    private String place;

    @Column(name = "explain")
    private String explain;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "metting_time")
    private Date mettingTime;

    @Column(name = "status")
    private boolean status;

    @Column(name = "unit_id")
    private int unitId;


    public int getMettingId() {
        return mettingId;
    }

    public void setMettingId(int value) {
        mettingId = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String value) {
        place = value;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String value) {
        explain = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date value) {
        createTime = value;
    }

    public Date getMettingTime() {
        return mettingTime;
    }

    public void setMettingTime(Date value) {
        mettingTime = value;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean value) {
        status = value;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int value) {
        unitId = value;
    }


}