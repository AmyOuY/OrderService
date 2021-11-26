package com.ymou.microservices.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ymou.microservices.OrderService.model.TransactionRequest;
import com.ymou.microservices.OrderService.model.TransactionResponse;
import com.ymou.microservices.OrderService.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	
	
	@PostMapping(path="/addOrder")
	public ResponseEntity<TransactionResponse> addOrder(@RequestBody TransactionRequest request){
		TransactionResponse response = service.addOrder(request);
		return new ResponseEntity<TransactionResponse>(response, HttpStatus.CREATED);
	}
}
