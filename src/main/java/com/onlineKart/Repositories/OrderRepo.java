package com.onlineKart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineKart.models.Order;
@Repository
public interface OrderRepo extends JpaRepository<Order, String>{

}
