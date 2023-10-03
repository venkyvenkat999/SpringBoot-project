package com.springboot.EmployeeManagement.service;

import com.springboot.EmployeeManagement.dao.IEmployeeDao;
import com.springboot.EmployeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private IEmployeeDao employeeDao;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public ResponseEntity<Optional<Employee>> findEmployee(Long deptId) {
        Optional<Employee> employee=employeeDao.findById(deptId);
        if(employee.isPresent()){
            return ResponseEntity.ok(employee);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Long deptId, Employee employee) {
         Optional<Employee> existingEmployeeOptional=employeeDao.findById(deptId);
         if(existingEmployeeOptional.isPresent()){
             Employee existingEmployee=existingEmployeeOptional.get();
             existingEmployee.setEmpName(employee.getEmpName());
             existingEmployee.setEmail(employee.getEmail());
             existingEmployee.setSalary(employee.getSalary());
             existingEmployee.setSupervisor(employee.getSupervisor());
             existingEmployee.setJoiningDate(employee.getJoiningDate());
             existingEmployee.setLastdate(employee.getLastdate());

             Employee updateEmployee=employeeDao.save(existingEmployee);

             return ResponseEntity.ok(updateEmployee);
         }
         else{
             return ResponseEntity.notFound().build();
         }
    }

    @Override
    public void deleteEmployee(Long deptId) {
        Optional<Employee> employee=employeeDao.findById(deptId);
        if(employee.isPresent()){
            employeeDao.deleteById(deptId);
            ResponseEntity.noContent().build();
        }
        else {
            ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<Employee> findEmployeesJoinedBetweenDates(LocalDate fromDate, LocalDate toDate) {
        return employeeDao.findEmployeesJoinedBetweenDates(fromDate,toDate);
    }

    @Override
    public List<Employee> findEmployeesUnderSupervisor(String supervisor) {
        return employeeDao.findEmployeesUnderSupervisor(supervisor);
    }

//    @Override
//    public Optional<Employee> findBySupervisorId(Long supervisorId) {
//        return employeeDao.findById(supervisorId);
//
//    }
}
