package com.ust.employee.controllers;

import com.ust.employee.models.Employee;
import com.ust.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/vendor/{vid}")
    public ResponseEntity<List<Employee>> getEmployeeByVid(@PathVariable("vid") int vid){
        return ResponseEntity.ok(employeeService.getEmployeeByVid(vid));
    }
}
