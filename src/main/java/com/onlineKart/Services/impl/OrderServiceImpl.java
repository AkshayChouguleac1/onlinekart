package com.onlineKart.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineKart.Repositories.OrderRepo;
import com.onlineKart.Services.OrderService;
import com.onlineKart.models.OrderModel;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepo orderRepo;
	
	@Override
	public OrderModel addNewOrder(OrderModel order) {
		return orderRepo.save(order);
	}

	@Override
	public OrderModel getOrderFromId(String id) {
		return orderRepo.findById(id).orElse(null);
	}

	@Override
	public List<OrderModel> getOrders() {
		return orderRepo.findAll();
	}

	@Override
	public OrderModel updateOrder(OrderModel order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(String id) {
		this.orderRepo.deleteById(id);
		
	}

	@Override
	public List<OrderModel> addAllOrders(List<OrderModel> orders) {
		return this.orderRepo.saveAll(orders);
	}
}
