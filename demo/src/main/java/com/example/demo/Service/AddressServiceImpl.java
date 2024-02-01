package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.repository.AdressesRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AdressesRepository addressesRepository;

   //1.GET/SELECT
    public Address getAddressDetails(Long id) {
        Address address = addressesRepository.findById(id).get();
        return address;
    }

   //2.POST/INSERT
    public String registerAddressDetails(Address address) {
        addressesRepository.save(address);
        return "Address with id"+ address.getAddressId()+ " is added successfully !";
    }

    //3.PUT/UPDATE
    public String updateAddressDetails(Address address) {
        addressesRepository.save(address);
        return "Address Details with id"+ address.getAddressId() + " is updated successfully !";
    }

    //4.DELETE
    public String deleteAddressEntry(Long id) {
        addressesRepository.deleteById(id);
        return "Address with id"+ id + " is removed successfully !";
    }

    
}
