package com.onlineKart.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineKart.models.OrderModel;

@Service
public interface OrderService {
	public OrderModel addNewOrder(OrderModel order);
	public OrderModel getOrderFromId(String id);
	public List<OrderModel> getOrders();
	public OrderModel updateOrder(OrderModel order);
	public void deleteOrder(String id);
	public List<OrderModel> addAllOrders(List<OrderModel> orders);
}
