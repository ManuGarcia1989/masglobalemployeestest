package com.example.employeesmasglobal.services;


import com.example.employeesmasglobal.entities.EmployeeEntity;
import com.example.employeesmasglobal.repositories.EmployeesRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService implements EmployeesInterfaceService{
    @Autowired
    private EmployeesRopository repository;


    @Override
    public List<EmployeeEntity> getEmployees() {
        List<EmployeeEntity> result = (List<EmployeeEntity>) repository.findAll();
        return result;
    }

    @Override
    public EmployeeEntity getEmployeeByCC(String CC) {
        EmployeeEntity result = (EmployeeEntity) repository.findByCC(CC);
        return result;
    }

    @Override
    public Boolean saveEmployee(EmployeeEntity employee) {
        try {
            repository.save(employee);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public Double getAnnualSalaryByCC(String CC) {
        EmployeeEntity employee = getEmployeeByCC(CC);
        if(employee != null) {
            Double result = 0.0;
            if (employee.getHourly()) {
                result = 120 * employee.getHourlySalary() * 12;
            } else {
                result = 120 * employee.getHourlySalary() * 12;
            }
            return result;
        }else {
            return null;
        }

    }

    @Override
    public Boolean deleteByCC(String CC) {
        try{
        repository.delete(getEmployeeByCC(CC));
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateEmployee(EmployeeEntity employee) {
        try{
            repository.delete(getEmployeeByCC(employee.getCC()));
            repository.save(employee);
        }catch (Exception ex){
            return null;
        }
        return true;
    }
}
