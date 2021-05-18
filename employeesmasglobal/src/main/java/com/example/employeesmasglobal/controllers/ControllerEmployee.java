package com.example.employeesmasglobal.controllers;


import com.example.employeesmasglobal.entities.EmployeeEntity;
import com.example.employeesmasglobal.routes.Router;
import com.example.employeesmasglobal.services.EmployeesService;
import com.example.employeesmasglobal.validators.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = Router.BASE)
public class ControllerEmployee {

    @Autowired
    public EmployeesService employeesService;

    @GetMapping(value = Router.EMPLOYEES)
    public ResponseEntity<List<EmployeeEntity>> getEmployees()
    {
        List<EmployeeEntity> employees = employeesService.getEmployees();
        return (employees.isEmpty())
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(employees);
    }

    @GetMapping(value = Router.EMPLOYEE)
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable("CC") String CC)
    {
        EmployeeEntity employee = employeesService.getEmployeeByCC(CC);
        return (employee == null)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(employee);
    }

    @PostMapping(value = Router.CREATE_EMPLOYEE)
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeEntity employee = new EmployeeEntity();
        employee.setCC(employeeRequest.getCC());
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setPosition(employeeRequest.getPosition());
        employee.setHourly(employeeRequest.getHourly());
        employee.setHourlySalary(employeeRequest.getHourlySalary());
        return employeesService.saveEmployee(employee)
                ? ResponseEntity.ok(employee)
                : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = Router.UPDATE_EMPLOYEE)
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeEntity employee = new EmployeeEntity();
        employee.setCC(employeeRequest.getCC());
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setPosition(employeeRequest.getPosition());
        employee.setHourly(employeeRequest.getHourly());
        employee.setHourlySalary(employeeRequest.getHourlySalary());
        return employeesService.updateEmployee(employee)
                ? ResponseEntity.ok(employee)
                : ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = Router.DELETE_EMPLOYEE)
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("CC") String CC){
        return employeesService.deleteByCC(CC)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(true);
    }

    @GetMapping(value = Router.ANNUAL_SALARY)
    public ResponseEntity<Double> getAnnualSalary(@PathVariable("CC") String CC){
        Double annualSalary = employeesService.getAnnualSalaryByCC(CC);
        return (annualSalary == null)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(annualSalary);
    }

}
