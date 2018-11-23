package com.hhxk.assessment.entity.service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "EXAMINATION")
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "examination_id")
    private int examinationId;

    @Column(name = "name")
    private String name;

    @Column(name = "duties")
    private String duties;

    @Column(name = "phone")
    private int phone;

    @Column(name = "explain")
    private String explain;

    @Column(name = "status")
    private boolean status;

    @Column(name = "unit_id")
    private int unitId;

    @Column(name = "type_id")
    private int typeId;

//    @JsonIgnore
//    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
//    @JoinTable(name = "sys_permission_role",
//            joinColumns = {@JoinColumn(name = "roleId", referencedColumnName = "roleId")},
//            inverseJoinColumns = {@JoinColumn(name = "permissionId", referencedColumnName = "permissionId")}
//    )
//    private List<>


    public int getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(int value) {
        examinationId = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String value) {
        duties = value;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int value) {
        phone = value;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String value) {
        explain = value;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int value) {
        typeId = value;
    }


}