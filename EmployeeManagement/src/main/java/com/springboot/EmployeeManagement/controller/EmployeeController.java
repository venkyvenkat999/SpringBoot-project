package com.springboot.EmployeeManagement.controller;
import com.springboot.EmployeeManagement.exceptions.InvalidDateFormatException;
import com.springboot.EmployeeManagement.model.Employee;
import com.springboot.EmployeeManagement.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){

        return employeeService.findAllEmployees();
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("retriveEmployee/{empId}")
    public ResponseEntity<Optional<Employee>> getById(@PathVariable Long empId){
        return employeeService.findEmployee(empId);
    }

    @PutMapping("updateEmployee/{empId}")
    public ResponseEntity<Employee> getUpdatedEmployee(@PathVariable Long empId,@RequestBody Employee employee){
        return employeeService.updateEmployee(empId,employee);
    }

    @DeleteMapping("deleteEmployee/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long empId){
        employeeService.deleteEmployee(empId);
        return ResponseEntity.ok("employee deleted successfully");
    }

//    @GetMapping("/supervisor/{empId}")
//    public Optional<Employee> getBySupervisorId(@PathVariable Long empId){
//        return employeeService.findBySupervisorId(empId);
//    }

//    @GetMapping("/joined/{one_date}/{two_date}")
//    public List<Employee> findEmployeesJoinedBetweenDates(@PathVariable(value = "one_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate, @PathVariable(value = "two_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate){
//        if(!isValidDateFormat(one_date) || !isValidDateFormat)
//        return employeeService.findEmployeesJoinedBetweenDates(fromDate,toDate);
//    }
@GetMapping("/joined/{one_date}/{two_date}")
public ResponseEntity<?> findEmployeesJoinedBetweenDates(@PathVariable(value = "one_date") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate fromDate, @PathVariable(value = "two_date") @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate toDate){

        String formattedDateOne=fromDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String formattedDateTwo=toDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if(!formattedDateOne.equals(fromDate.toString()) || !formattedDateTwo.equals(toDate.toString())){
        throw new InvalidDateFormatException("invalid date format please use dd-MM-yyyy");
    }
    try{
        List<Employee> employees=employeeService.findEmployeesJoinedBetweenDates(fromDate,toDate);
        return ResponseEntity.ok(employees);
   } catch (Exception e) {
        throw new InvalidDateFormatException("invalid date format please use dd-MM-yyyy");
    }
}
    @GetMapping("supervisorName/{supervisor}")
    public List<Employee> getEmployeesUnderSupervisor(@PathVariable String supervisor){
        return employeeService.findEmployeesUnderSupervisor(supervisor);
    }

}
