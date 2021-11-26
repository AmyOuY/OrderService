package com.ymou.microservices.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ymou.microservices.OrderService.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
