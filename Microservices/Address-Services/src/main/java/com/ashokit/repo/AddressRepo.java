package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
