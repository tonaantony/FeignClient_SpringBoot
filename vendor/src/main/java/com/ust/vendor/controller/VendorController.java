package com.ust.vendor.controller;

import com.ust.vendor.config.FullResponse;
import com.ust.vendor.model.Vendor;
import com.ust.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping("/add")
    public Vendor addVendor(@RequestBody Vendor vendor){
        return vendorService.addVendor(vendor);
    }
    @GetMapping("/get")
    public List<Vendor> getAllVendors(){
        return vendorService.getAllVendors();
    }
    @GetMapping("/vendor/{vid}")
    public ResponseEntity<FullResponse> getVendorById(@PathVariable("vid") int vid){
        return ResponseEntity.ok(vendorService.getVendorById(vid));
    }
}
