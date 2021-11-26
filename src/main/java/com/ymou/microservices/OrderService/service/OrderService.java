package com.ymou.microservices.OrderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ymou.microservices.OrderService.entity.Order;
import com.ymou.microservices.OrderService.model.Payment;
import com.ymou.microservices.OrderService.model.TransactionRequest;
import com.ymou.microservices.OrderService.model.TransactionResponse;
import com.ymou.microservices.OrderService.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	public TransactionResponse addOrder(TransactionRequest request) {
		String message = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setAmount(order.getPrice() * order.getQuantity());
		payment.setOrderId(order.getId());
		
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/addPayment", payment, Payment.class);
		
		message = paymentResponse.getPaymentStatus().equals("success") ? "Successfully paid and order placed" : "Payment failed and order added to cart";
		repo.save(order);
		
		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), message);
	}
}
