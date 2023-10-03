package com.springboot.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;

    private String email;

    private Double salary;

   // @ManyToOne
    private String supervisor;

    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_of_joining")
    private Date joiningDate;
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_of_leaving")
    private Date lastdate;
//    @Column(name = "deptId")
//    private Long deptId;
//    @ManyToOne
//    @JoinColumn(name="deptId")
//    private Company company;




}
