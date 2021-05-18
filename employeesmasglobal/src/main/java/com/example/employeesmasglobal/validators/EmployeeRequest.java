package com.example.employeesmasglobal.validators;

import com.fasterxml.jackson.annotation.JsonProperty;



public class EmployeeRequest {
    public EmployeeRequest(String CC, String FirstName, String LastName, String Position, Boolean Hourly, Double HourlySalary) {
        this.CC = CC;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Position = Position;
        this.Hourly = Hourly;
        this.HourlySalary = HourlySalary;
    }

    @JsonProperty("CC")
    private String CC;

    @JsonProperty("FirstName")
    private String FirstName;

    @JsonProperty("LastName")
    private String LastName;

    @JsonProperty("Position")
    private String Position;

    @JsonProperty("Hourly")
    private Boolean Hourly;

    @JsonProperty("HourlySalary")
    private Double HourlySalary;

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Boolean getHourly() {
        return Hourly;
    }

    public void setHourly(Boolean hourly) {
        Hourly = hourly;
    }

    public Double getHourlySalary() {
        return HourlySalary;
    }

    public void setHourlySalary(Double hourlySalary) {
        HourlySalary = hourlySalary;
    }
}
