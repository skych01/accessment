package com.hhxk.assessment.entity.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UNIT")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unit_id")
    private int unitId;

    @Column(name = "name")
    private String name;

    @Column(name = "explain")
    private String explain;

    @Column(name = "parent_id")
    private int parentId;


    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int value) {
        unitId = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String value) {
        explain = value;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int value) {
        parentId = value;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitId=" + unitId +
                ", name='" + name + '\'' +
                ", explain='" + explain + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}