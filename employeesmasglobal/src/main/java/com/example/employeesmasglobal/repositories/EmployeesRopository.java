package com.example.employeesmasglobal.repositories;


import com.example.employeesmasglobal.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRopository extends JpaRepository<EmployeeEntity,String> {
    EmployeeEntity findByCC(String cc);
}
