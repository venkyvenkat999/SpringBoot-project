package com.springboot.EmployeeManagement.service;

import com.springboot.EmployeeManagement.dao.IComapanyDao;
import com.springboot.EmployeeManagement.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private  IComapanyDao comapanyDao;
    @Override
    public Company saveDepartment(Company company) {
        return comapanyDao.save(company);


    }

    @Override
    public List<Company> findAllDepartments() {
        return comapanyDao.findAll();
    }

    @Override
    public ResponseEntity<Optional<Company>> findDepartment(Long deptId) {

        Optional<Company> company=comapanyDao.findById(deptId);
        if(company.isPresent()){
            return ResponseEntity.ok(company);
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    public ResponseEntity<Company> updateDepartment(Long deptId, Company company) {
     Optional<Company> existingDepartmentOptional=comapanyDao.findById(deptId);
     if(existingDepartmentOptional.isPresent()){
         Company existingDeprtment=existingDepartmentOptional.get();
         existingDeprtment.setDeptName(company.getDeptName());
         existingDeprtment.setListOfEmployees(company.getListOfEmployees());
         existingDeprtment.setDescription(company.getDescription());

         Company updatedDepartment=comapanyDao.save(existingDeprtment);

         return ResponseEntity.ok(updatedDepartment);

     }
     else{
         return ResponseEntity.notFound().build();
     }
    }

//    @Override
//    public void deleteDepartment(Long deptId) {
//        Optional<Company> company=comapanyDao.findById(deptId);
//        if(company.isPresent()){
//            comapanyDao.deleteById(deptId);
//            ResponseEntity.noContent().build();
//        }
//        else {
//            ResponseEntity.notFound().build();
//        }
//    }

}
