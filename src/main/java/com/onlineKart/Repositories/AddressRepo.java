package com.onlineKart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineKart.models.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, String> {

}
