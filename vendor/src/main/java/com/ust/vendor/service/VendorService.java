package com.ust.vendor.service;

import com.ust.vendor.config.Employee;
import com.ust.vendor.config.FullResponse;
import com.ust.vendor.feign.EmployeeDetails;
import com.ust.vendor.model.Vendor;
import com.ust.vendor.repository.VendorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private EmployeeDetails employeeDetails;

    public Vendor addVendor(Vendor vendor){
        return vendorRepository.save(vendor);
    }
    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }
    public FullResponse getVendorById(int vid){
        Vendor vendor = vendorRepository.findById(vid).orElse(null);
        List<Employee> employee = employeeDetails.findAllEmployeeByVendor(vid);
        FullResponse fullResponse = new FullResponse();
        fullResponse.setName(vendor.getName());
        fullResponse.setAddress(vendor.getAddress());
        fullResponse.setPhone(vendor.getPhone());
        fullResponse.setEmployee(employee);
        return fullResponse;
    }
}
