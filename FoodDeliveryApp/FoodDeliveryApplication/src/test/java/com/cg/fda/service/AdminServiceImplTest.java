package com.cg.fda.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fda.domain.Order;
import com.cg.fda.domain.FoodCart;
import com.cg.fda.repository.OrderRepository;
import com.cg.fda.repository.FoodCartRepository;

/**
 * The AdminServiceTest class provides testing of AdminService layer
 * 
 * @author Amrutha R
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {

	@MockBean
	private FoodCartRepository foodcartRepository;

	@MockBean
	private OrderRepository orderRepository;

	@Autowired
	private AdminService adminService;

	@Test
	public void testCreateFoodCart() throws Exception {
		FoodCart foodcart = new FoodCart(106, "Chillies", "pizza", "8");
		Mockito.when(foodcartRepository.save(foodcart)).thenReturn(foodcart);
		assertThat(adminService.createFoodCart(foodcart)).isEqualTo(foodcart);
	}

	@Test
	public void testDeleteFoodCartById() throws Exception {
		FoodCart foodcart = new FoodCart(106, "Chillies", "pizza", "8");
		foodcartRepository.deleteById(foodcart.getFoodCartId());
		System.out.println(foodcartRepository.findById(101));
		Assert.assertTrue(foodcartRepository.findById(101).isEmpty());
	}

	@Test
	public void testUpdateFoodCartById() throws Exception {
		FoodCart foodcart = new FoodCart(106, "Chillies", "pizza", "8");
		Mockito.when(foodcartRepository.save(foodcart)).thenReturn(foodcart);
		foodcart.setRestaurantName("Chillies");
		foodcart.setFoodItemName("pizza");
		foodcart.setFoodItemQuantity("8");
		System.out.println(foodcart.getRestaurantName());
		System.out.println(foodcart.getFoodItemName());
		System.out.println(foodcart.getFoodItemQuantity());
		Assert.assertTrue((foodcartRepository.findById(101).isEmpty()));
	}

	@Test
	public void testGetAllFoodCart() throws Exception {
		FoodCart foodcart1 = new FoodCart(106, "Chillies", "pizza", "8");
		FoodCart foodcart2 = new FoodCart(106, "Chillies", "pizza", "8");
		List<FoodCart> foodcartlist = new ArrayList<>();
		foodcartlist.add(foodcart1);
		foodcartlist.add(foodcart2);

		Mockito.when(foodcartRepository.findAll()).thenReturn(foodcartlist);
		assertThat(adminService.getAllFoodCart()).isEqualTo(foodcartlist);

	}

	@Test
	public void testCreateOrder() throws Exception {
		Order order = new Order(3, "shivani", "9550355319", "shivani@gmail.com", "125/B");
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		assertThat(adminService.createOrder(order)).isEqualTo(order);
	}

	@Test
	public void testUpdateOrderById() throws Exception {
		Order order = new Order(3, "shivani", "9550355319", "shivani@gmail.com", "125/B");
		Mockito.when(orderRepository.save(order)).thenReturn(order);

		order.setUserName("shivani.s@gmail.com");
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		System.out.println(order.getUserName());

		Assert.assertTrue(orderRepository.findById(3).isEmpty());

	}

	@Test
	public void testDeleteOrderById() throws Exception {

		Order order = new Order(3, "shivani", "9550355319", "shivani@gmail.com", "125/B");
		orderRepository.deleteById(order.getOrderId());
		System.out.println(orderRepository.findById(3));
		Assert.assertTrue(orderRepository.findById(3).isEmpty());
	}

	@Test
	public void testGetAllOrder() throws Exception {
		Order order1 = new Order(3, "shivani", "9550355319", "shivani@gmail.com", "125/B");
		Order order2 = new Order(1, "shivani", "9550355319", "shivani@gmail.com", "125/B");
		List<Order> orderlist = new ArrayList<>();
		orderlist.add(order1);
		orderlist.add(order2);

		Mockito.when(orderRepository.findAll()).thenReturn(orderlist);
		assertThat(adminService.getAllOrder()).isEqualTo(orderlist);
	}
}
