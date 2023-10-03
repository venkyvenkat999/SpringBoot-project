package com.springboot.EmployeeManagement.service;

import com.springboot.EmployeeManagement.model.Employee;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> findAllEmployees();

    ResponseEntity<Optional<Employee>> findEmployee(Long deptId);
    ResponseEntity<Employee> updateEmployee(Long deptId,Employee employee);

    void deleteEmployee(Long deptId);

//    Optional<Employee> findBySupervisorId(Long supervisorId);
 List<Employee>findEmployeesJoinedBetweenDates(LocalDate fromDate, LocalDate toDate);

    List<Employee> findEmployeesUnderSupervisor(String supervisor);

}
