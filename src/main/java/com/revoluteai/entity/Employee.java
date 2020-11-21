package com.revoluteai.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@ApiModel
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "EMPLOYEE_ID")
    @ApiModelProperty(value=" Id of the employee")
    private Long employeeId;

    @ApiModelProperty(value="EMPLOYEE NAME")
    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @ApiModelProperty(value="TITLE of the employee")
    @Column(name = "TITLE")
    private String title;

    @ApiModelProperty(value="BUSINESS UNIT of the employee")
    @Column(name = "BUSINESS_UNIT")
    private String businessUnit;

    @ApiModelProperty(value="PLACE OF THE EMPLOYEE")
    @Column(name = "PLACE")
    private String place;

    @ApiModelProperty(value="SUPERVISORID OF THE EMPLOYEE")
    @Column(name = "SUPERVISOR_ID")
    private Long superVisorId;

    @ApiModelProperty(value="COMPETENCIES OF THE EMPLOYEE")
    @Column(name = "COMPETENCIES")
    private String compentencies;

    @ApiModelProperty(value="Salary of the Employee")
    @Column(name = "SALARY")
    private double salary;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getSuperVisorId() {
        return superVisorId;
    }

    public void setSuperVisorId(Long superVisorId) {
        this.superVisorId = superVisorId;
    }

    public String getCompentencies() {
        return compentencies;
    }

    public void setCompentencies(String compentencies) {
        this.compentencies = compentencies;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
