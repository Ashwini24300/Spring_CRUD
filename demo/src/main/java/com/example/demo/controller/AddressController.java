package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Address;
import com.example.demo.DTO.ApiResponse;
import com.example.demo.Service.AddressService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    //1.GET/SELECT
    @GetMapping("/getAddressDetails/{addressId}")
    public ResponseEntity<?>  getAddressDetails(@PathVariable Long addressId) throws Exception {
        return ResponseEntity.ok().body(new ApiResponse(addressService.getAddressDetails(addressId).toString()));
    }

    //2.POST/INSERT
    @PostMapping("/registerAddressDetails")
    public ResponseEntity<?> registerAddressDetails(@RequestBody Address address) {
        return ResponseEntity.ok().body(new ApiResponse(addressService.registerAddressDetails(address)));
    }

    //3.PUT/UPDATE
    @PutMapping("/updateAddressDetails")
    public ResponseEntity<?> updateAddressDetails(@RequestBody Address address) throws Exception {
		return ResponseEntity.ok().body(new ApiResponse(addressService.updateAddressDetails(address)));
    }

    //4.DELETE
    @DeleteMapping("/deleteAddressDetails/{addressId}")
    public ResponseEntity<?> deleteStudentEntry(@PathVariable Long addressId) {
		return ResponseEntity.ok().body(new ApiResponse(addressService.deleteAddressEntry(addressId)));
	}
    

    
}
