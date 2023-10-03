package com.springboot.EmployeeManagement.dao;

import com.springboot.EmployeeManagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IComapanyDao extends JpaRepository<Company,Long> {

}
