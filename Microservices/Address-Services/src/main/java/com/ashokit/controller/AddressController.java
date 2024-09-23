package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Address;
import com.ashokit.services.AddressServices;

@RestController
public class AddressController {
	@Autowired
	private AddressServices addService;
	
	@PostMapping("/save")
	public ResponseEntity<Boolean> saveAddress(@RequestBody List<Address> address){
		boolean address2 = addService.addAddress(address);
		return new ResponseEntity<Boolean>(address2,HttpStatus.CREATED);
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> findAddressById(@PathVariable("id") Integer id){
		Address address = addService.getAddressById(id);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
	
	@GetMapping("/address")
	public  ResponseEntity<List<Address>> findAllAddress(){
		List<Address> address = addService.getAddress();
		return new ResponseEntity<List<Address>>(address, HttpStatus.OK);
	}

}
