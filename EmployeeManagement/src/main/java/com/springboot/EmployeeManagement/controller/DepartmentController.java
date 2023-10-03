package com.springboot.EmployeeManagement.controller;

import com.springboot.EmployeeManagement.dao.IComapanyDao;
import com.springboot.EmployeeManagement.model.Company;
import com.springboot.EmployeeManagement.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
    @Autowired
    private  CompanyServiceImpl companyService;

    @Autowired
    private IComapanyDao comapanyDao;

    @PostMapping("/addDepartment")
    public ResponseEntity<Company> addDepartment(@RequestBody Company company){
        Company addDepartment=companyService.saveDepartment(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(addDepartment);

    }

    @GetMapping
    public List<Company> getAllDepartments(){
        return companyService.findAllDepartments();
    }

    @GetMapping("/retrive/{deptId}")
    public ResponseEntity<Optional<Company>> getById(@PathVariable Long deptId){
        return companyService.findDepartment(deptId);
    }

    @PutMapping("/update/{deptId}")
    public ResponseEntity<Company> getUpdatedDepartment(@PathVariable Long deptId,@RequestBody Company company){
        return companyService.updateDepartment(deptId,company);
    }

//    @DeleteMapping("/delete/{deptId}")
//    public ResponseEntity<String> deleteDepartment(@PathVariable Long deptId){
//        companyService.deleteDepartment(deptId);
//        return ResponseEntity.ok("department deleted successfully");
//    }
    @DeleteMapping("/delete/{deptId}")
    public ResponseEntity<Map<String,Boolean>> deleteDepartment(@PathVariable Long deptId){
        Optional<Company> company=comapanyDao.findById(deptId);
        comapanyDao.deleteById(deptId);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);


    }

}
