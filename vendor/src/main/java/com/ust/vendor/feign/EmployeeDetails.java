package com.ust.vendor.feign;

import com.ust.vendor.config.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Employee-Services", url = "http://localhost:9097/employee")
public interface EmployeeDetails {
    @GetMapping("/vendor/{vid}")
    List<Employee> findAllEmployeeByVendor(@PathVariable("vid") int vid);
}
