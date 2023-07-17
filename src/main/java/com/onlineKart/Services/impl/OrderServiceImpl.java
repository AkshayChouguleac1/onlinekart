package com.onlineKart.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineKart.Repositories.OrderRepo;
import com.onlineKart.Services.OrderService;
import com.onlineKart.models.Order;

public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepo orderRepo;
	
	@Override
	public Order addNewOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order getOrderFromId(String id) {
		return orderRepo.findById(id).orElse(null);
	}

	@Override
	public List<Order> getOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(String id) {
		this.orderRepo.deleteById(id);
		
	}

	@Override
	public List<Order> addAllOrders(List<Order> orders) {
		return this.orderRepo.saveAll(orders);
	}
}
