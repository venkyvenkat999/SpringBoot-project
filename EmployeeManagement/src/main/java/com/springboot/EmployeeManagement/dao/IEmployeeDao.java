package com.springboot.EmployeeManagement.dao;

import com.springboot.EmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee,Long> {
    @Query(value = "select * from employees t where date_of_joining BETWEEN :startDate AND :endDate",nativeQuery = true)
    List<Employee> findEmployeesJoinedBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value ="select * from employees t where t.supervisor= :name",nativeQuery = true)
    List<Employee> findEmployeesUnderSupervisor(@Param("name") String supervisor);
}
