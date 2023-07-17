package com.onlineKart.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineKart.Repositories.AddressRepo;
import com.onlineKart.Services.AddressService;
import com.onlineKart.models.Address;

public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepo addressRepo;
	
	@Override
	public Address addNewAddress(Address address) {
		return addressRepo.save(address);
	}

	@Override
	public Address getAddressFromId(String id) {
		return addressRepo.findById(id).orElse(null);
	}

	@Override
	public List<Address> getAddresses() {
		return addressRepo.findAll();
	}

	@Override
	public Address updateAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAddress(String id) {
		this.addressRepo.deleteById(id);
		
	}

	@Override
	public List<Address> addAllAddresss(List<Address> addresss) {
		return this.addressRepo.saveAll(addresss);
	}

}