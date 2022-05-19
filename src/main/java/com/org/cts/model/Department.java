package com.org.cts.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Department {
    @Id
    private int id;
    private String deptName;
    private String deptAddress;
    private double deptNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public double getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(double deptNumber) {
        this.deptNumber = deptNumber;
    }
}
