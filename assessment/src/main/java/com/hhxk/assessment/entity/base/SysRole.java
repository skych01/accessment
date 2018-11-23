package com.hhxk.assessment.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "sys_role")
public class SysRole {
    @Id
    private int roleId;
    private String name;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "sys_permission_role",
            joinColumns = {@JoinColumn(name = "roleId", referencedColumnName = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "permissionId", referencedColumnName = "permissionId")}
    )
    private List<SysResource> resources;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return name;
    }

    public void setRoleName(String roleName) {
        this.name = roleName;
    }

}
