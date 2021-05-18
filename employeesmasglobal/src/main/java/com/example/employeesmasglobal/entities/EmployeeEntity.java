package com.example.employeesmasglobal.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees")
@Data
public class EmployeeEntity implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String CC;
    private String FirstName;
    private String LastName;
    private String Position;
    private Boolean Hourly;
    private Double HourlySalary;


}
