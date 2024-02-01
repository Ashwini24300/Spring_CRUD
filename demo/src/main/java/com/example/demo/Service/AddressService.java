package com.example.demo.Service;
import com.example.demo.entity.Address;


public interface AddressService {
    Address getAddressDetails(Long id);
    String registerAddressDetails(Address address);
    String updateAddressDetails(Address address);
    String deleteAddressEntry(Long id);
}
