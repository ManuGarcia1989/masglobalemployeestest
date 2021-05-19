package com.example.employeesmasglobal.configuration;

import com.example.employeesmasglobal.entities.EmployeeEntity;
import com.example.employeesmasglobal.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner  implements ApplicationRunner {
    @Autowired
    public EmployeesService service;
    private EmployeeEntity employee1 = new EmployeeEntity();
    private EmployeeEntity employee2 = new EmployeeEntity();
    @Override
    public void run(ApplicationArguments args) throws Exception {
        employee1.setCC("1234");
        employee1.setFirstName("Name Test 1");
        employee1.setLastName("Last Name 1");
        employee1.setPosition("Developer");
        employee1.setHourly(false);
        employee1.setHourlySalary(100.0);

        employee2.setCC("4321");
        employee2.setFirstName("Name Test 2");
        employee2.setLastName("Last Name 2");
        employee2.setPosition("Developer");
        employee2.setHourly(true);
        employee2.setHourlySalary(80.0);

        service.saveEmployee(employee1);
        service.saveEmployee(employee2);
    }
}
