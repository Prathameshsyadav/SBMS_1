package com.ashokit.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashokit.entity.Address;

@FeignClient(name = "ADDRESS-SERVICES")
public interface AddressApiClient {

	@GetMapping("/address")
	public List<Address> invokeAddress();
}
