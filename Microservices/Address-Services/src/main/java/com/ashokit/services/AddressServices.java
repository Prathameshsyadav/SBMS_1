package com.ashokit.services;

import java.util.List;

import com.ashokit.entity.Address;

public interface AddressServices {

	public boolean addAddress(Address address);
	
	public Address getAddressById(Integer id);
	
	public List<Address> getAddress();
}
