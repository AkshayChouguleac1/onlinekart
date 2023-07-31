package com.onlineKart.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineKart.Services.AddressService;
import com.onlineKart.models.Address;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	
	@GetMapping("/getAddress/{addresss_id}")
	public ResponseEntity<Address> getAddresss(@PathVariable(name = "addresss_id") String id){
		Address fetchedAddresss=this.addressService.getAddressFromId(id);
		return new ResponseEntity<Address>(fetchedAddresss,HttpStatus.OK);
	}
	
	@GetMapping("/getAllAddresss")
	public ResponseEntity<List<Address>> getAllIems(){
		
		return new ResponseEntity<List<Address>>(this.addressService.getAddresses(),HttpStatus.OK);
	}

	
	@PostMapping("/addAddress")
	public ResponseEntity<Address> addAddresss(@RequestBody Address addresss){
		return new ResponseEntity<Address>(this.addressService.addNewAddress(addresss),HttpStatus.OK);
	}
	
	@PostMapping("/updateAddress")
	public ResponseEntity<Address> updateAddresss(@RequestBody Address addresss){
		return new ResponseEntity<Address>(this.addressService.updateAddress(addresss),HttpStatus.OK);
	}
	
	@PostMapping("/addAddressss")
	public ResponseEntity<List<Address>> addAddressss(@RequestBody List<Address> addresssList){
		List savedAddresss= this.addressService.addAllAddresss(addresssList);
		return new ResponseEntity<List<Address>>(savedAddresss,HttpStatus.OK);
		
		
		//return new ResponseEntity<List<Address>>(savedAddresss,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAddress/{addresss_id}")
	public HttpStatus deleteAddress(@PathVariable(name = "addresss_id") String id){
		this.addressService.deleteAddress(id);
		return HttpStatus.OK;
		
	}
}
