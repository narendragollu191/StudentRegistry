package com.example.demo.student;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController  {

    private final AddressService addressService;

    @Autowired
    public  AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping("/newAddress")
    public void addNewAddress(@RequestBody Address address)
    {
        // System.out.println("saved address :" + address);
        addressService.addAddress(address);
    }

    @GetMapping("/all")
    public List<Address> getAllAddress(){
        return addressService.getTheAddress();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Integer id, @RequestParam(required = false) String streetname, @RequestParam(required = false) String zipcode) throws IOException
    {
        addressService.updatePresentAddress(id,streetname,zipcode);
        return  ResponseEntity.ok("Address updated successfully");

    }


}
