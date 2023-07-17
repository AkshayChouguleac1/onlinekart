package com.onlineKart.Services;

import java.util.List;

import com.onlineKart.models.Address;


public interface AddressService {
	public List<Address> getAddressByDate(String date);
	public Address addNewAddress(Address address);
	public Address getAddressFromId(int id);
	public List<Address> getAddresss();
	public Address updateAddress(Address address);
	public void deleteAddress(int id);
	public List<Address> addAllAddresss(List<Address> addresss);
}
