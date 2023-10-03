package com.springboot.EmployeeManagement.service;

import com.springboot.EmployeeManagement.model.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    Company saveDepartment(Company company);
    List<Company> findAllDepartments();

    ResponseEntity<Optional<Company>> findDepartment(Long deptId);
    ResponseEntity<Company> updateDepartment(Long deptId,Company company);

//    void deleteDepartment(Long deptId);
}
