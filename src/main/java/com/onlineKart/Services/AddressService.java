package com.onlineKart.Services;

import java.util.List;

import com.onlineKart.models.Address;


public interface AddressService {
	public Address addNewAddress(Address address);
	public Address getAddressFromId(String id);
	public List<Address> getAddresses();
	public Address updateAddress(Address address);
	public void deleteAddress(String id);
	public List<Address> addAllAddresss(List<Address> addresss);
}
