package com.ashokit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Address;
import com.ashokit.repo.AddressRepo;

@Service
public class AddressServiceImpl implements AddressServices {
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public boolean addAddress(Address address) {
		Address save = addressRepo.save(address);
		return save.getId() != null;
		
	}

	@Override
	public Address getAddressById(Integer id) {
		// TODO Auto-generated method stub
		return addressRepo.findById(id).get();
	}

	@Override
	public List<Address> getAddress() {
		// TODO Auto-generated method stub
		return addressRepo.findAll();
	}

}
