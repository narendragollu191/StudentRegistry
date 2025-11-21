package com.example.demo.student;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
public class AddressService{

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void addAddress(Address address){
        // System.out.println("saved address :" + address);
        addressRepository.save(address);
    }

    public List<Address> getTheAddress(){
        return addressRepository.findAll();
    }

    @Transactional
    public void updatePresentAddress(Integer id, String streetname, String zipcode) throws IOException
    {
        Address address = (addressRepository.findById(id)
        .orElseThrow(() -> new IOException("the address Id " + id + "does not exist")));
                               
        address.setStreetname(streetname);
        address.setZipcode(zipcode);
    }
}



