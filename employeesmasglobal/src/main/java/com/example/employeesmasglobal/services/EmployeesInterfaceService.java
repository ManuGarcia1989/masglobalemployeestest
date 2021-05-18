package com.example.employeesmasglobal.services;

import com.example.employeesmasglobal.entities.EmployeeEntity;

import java.util.List;

public interface EmployeesInterfaceService {
    List<EmployeeEntity> getEmployees();
    EmployeeEntity getEmployeeByCC(String CC);
    Boolean saveEmployee(EmployeeEntity employee);
    Double getAnnualSalaryByCC(String CC);
    Boolean deleteByCC(String CC);
    Boolean updateEmployee(EmployeeEntity employee);
}
