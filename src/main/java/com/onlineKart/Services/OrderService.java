package com.onlineKart.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineKart.models.Order;

@Service
public interface OrderService {
	public Order addNewOrder(Order order);
	public Order getOrderFromId(String id);
	public List<Order> getOrders();
	public Order updateOrder(Order order);
	public void deleteOrder(String id);
	public List<Order> addAllOrders(List<Order> orders);
}
