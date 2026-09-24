package com.example.Order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Order.entity.Order;
import com.example.Order.exception.OrderNotFoundException;
import com.example.Order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order createOrder(Order order) {

		order.setStatus("CREATED");

		return orderRepository.save(order);
	}

	@Override
	public Order getOrder(Long id) {

		return orderRepository.findById(id)
				.orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order updateOrder(Long id, Order order) {

		Order existingOrder = getOrder(id);

		existingOrder.setCustomerName(order.getCustomerName());
		existingOrder.setProductName(order.getProductName());
		existingOrder.setQuantity(order.getQuantity());
		existingOrder.setAmount(order.getAmount());

		return orderRepository.save(existingOrder);
	}

	@Override
	public void deleteOrder(Long id) {

		Order order = getOrder(id);

		orderRepository.delete(order);
	}
}
