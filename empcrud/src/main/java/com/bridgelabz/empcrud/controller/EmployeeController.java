package com.bridgelabz.empcrud.controller;

import com.bridgelabz.empcrud.exception.EmployeeException;
import com.bridgelabz.empcrud.model.Employee;
import com.bridgelabz.empcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
    @RestController
    @RequestMapping("/api/v1")

    public class EmployeeController {
        @Autowired
        private EmployeeRepository employeeRepository;

        //getEmployees
        @GetMapping("/employees")
        public List<Employee> getAllEmployees(){
            return employeeRepository.findAll();
        }

        //create employee
        @PostMapping("/createemployees")
        public Employee createEmployee(@RequestBody Employee employee){
            return employeeRepository.save(employee);
        }

        // get employee by id rest api
        @GetMapping("/employees/{id}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
            Employee employee = employeeRepository.findById(id)
                    .orElseThrow(() -> new EmployeeException("Employee not exist with id :" + id));
            return ResponseEntity.ok(employee);
        }

        //update employee rest api
        @PutMapping("/employees/{id}")
        public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
            Employee employee = employeeRepository.findById(id)
                    .orElseThrow(() -> new EmployeeException("Employee not exist with id :" + id));
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmailId(employeeDetails.getEmailId());

            Employee updatedEmployees=employeeRepository.save(employee);
            return ResponseEntity.ok(updatedEmployees);
        }

        @DeleteMapping("/employees/{id}")
        public String deleteEmployee(@PathVariable ("id") long id){
            Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee not exist with id:" + id));
            employeeRepository.delete(employee);
            return "deleted Succesfully";
        }

    }

