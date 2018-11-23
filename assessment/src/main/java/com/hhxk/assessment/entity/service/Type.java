package com.hhxk.assessment.entity.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TYPE")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "type_id")
    private int typeId;

    @Column(name = "type_content")
    private String typeContent;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int value) {
        typeId = value;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String value) {
        typeContent = value;
    }


}