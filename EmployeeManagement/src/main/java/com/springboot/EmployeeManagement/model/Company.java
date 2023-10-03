package com.springboot.EmployeeManagement.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    @Column(name="department")
    private String deptName;

    @Column(name="list_of_employees")
    private Long listOfEmployees;

    @Column(name="description")
    private String description;

//    @OneToMany(mappedBy = "company")
//    private List<Employee> employees;


}
