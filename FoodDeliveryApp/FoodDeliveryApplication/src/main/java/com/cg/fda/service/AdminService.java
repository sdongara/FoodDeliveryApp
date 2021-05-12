package com.cg.fda.service;

import java.util.List;
import java.util.function.IntPredicate;

import com.cg.fda.exception.IDNotFoundException;
import com.cg.fda.domain.FoodCart;
import com.cg.fda.domain.Order;

public interface AdminService {
	
	FoodCart createFoodCart(FoodCart foodcart);
	FoodCart updateFoodCartById(Integer foodCartId, FoodCart foodCartDetails) throws IDNotFoundException;
	boolean deleteFoodCartById(Integer foodCartId) throws IDNotFoundException;
	List<FoodCart> getAllFoodCart();
	
	Order createOrder(Order order);
    Order updateOrderById(Integer orderId, Order orderDetails) throws IDNotFoundException;
    boolean deleteOrderById(Integer orderId) throws IDNotFoundException;
	List<Order> getAllOrder();



}