package com.cg.fda.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.fda.domain.FoodCart;
import com.cg.fda.domain.Order;
import com.cg.fda.service.AdminService;
import com.cg.fda.web.AdminController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AdminController.class)
public class AdminControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	AdminService adminService;

	@Test
	public void testCreateFoodCart() throws Exception {

		FoodCart foodcart = new FoodCart(106, "Janani", "Chillies", "7");
		String jsonInput = this.converttoJson(foodcart);

		Mockito.when(adminService.createFoodCart(Mockito.any(FoodCart.class))).thenReturn(foodcart);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/fooddelivery/FoodCart")
				.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}


	/*@Test
	public void testUpdateFoodCart() throws Exception {
		FoodCart foodcart = new FoodCart(106, "Janani", "Chillies", "7");
		String jsonInput = this.converttoJson(foodcart);

		Mockito.when(adminService.updateFoodCartById(Mockito.any(), Mockito.any(FoodCart.class)))
				.thenReturn(foodcart);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.put("/fooddelivery/foodcart/{id}")
						.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}*/
	
	@Test
	public void testDeleteFoodCart() throws Exception {
		String URI = "/fda/foodcart/delete/{id}";
		FoodCart foodcart = new FoodCart(107, "saran", "Manal", "9");
		adminService.deleteFoodCartById(foodcart.getFoodCartId());
		assertThat(adminService.deleteFoodCartById(107)).isFalse();
	}

	@Test
	public void testGetAllFoodCarts() throws Exception {

		FoodCart foodcart1 = new FoodCart(106, "Janani", "Chillies", "8");
		FoodCart foodcart2 = new FoodCart(102, "Nivi", "Manal", "8");

		List<FoodCart> foodcartlist = new ArrayList<>();
		foodcartlist.add(foodcart1);
		foodcartlist.add(foodcart2);

		String jsonInput = this.converttoJson(foodcartlist);
		Mockito.when(adminService.getAllFoodCart()).thenReturn(foodcartlist);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/fooddelivery/FoodCart")
				.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	@Test
	public void testCreateOrder() throws Exception {
		Order order = new Order(3, "shivani", "9550355319", "shivani@gmail.com", "125/B");
		String jsonInput = this.converttoJson(order);
		Mockito.when(adminService.createOrder(Mockito.any(Order.class))).thenReturn(order);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/fooddelivery/Order")
				.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	@Test
	public void testDeleteOrderById() throws Exception {
		String URI = "/fda/Order/delete/{id}";
		Order order= new Order(3, "shivani", "9121393187", "shivani@gmail.com", "Banglore");
		adminService.deleteOrderById(order.getOrderId());
		assertThat(adminService.deleteOrderById(3)).isFalse();
	}

/*	@Test
	public void testUpdateOrder() throws Exception {
		Order order = new Order(4, "Kumar", "9573304286", "kumar@gmail.com", "Tirupathi");
		String jsonInput = this.converttoJson(order);
		Mockito.when(adminService.updateOrderById(Mockito.any(), Mockito.any(Order.class))).thenReturn(order);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.put("/fooddelivery/Order/{id}")
						.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}*/

	@Test
	public void testGetAllOrder() throws Exception {

		Order order1 = new Order(4, "Kumar", "9573304286", "kumar@gmail.com", "Tirupathi");
		Order order2 = new Order(4, "Kumar", "9573304286", "kumar@gmail.com", "Tirupathi");
		List<Order> orderlist = new ArrayList<>();
		orderlist.add(order1);
		orderlist.add(order2);
		String jsonInput = this.converttoJson(orderlist);

		Mockito.when(adminService.getAllOrder()).thenReturn(orderlist);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/fooddelivery/Order").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);

	}

	private String converttoJson(Object companymanager) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(companymanager);
	}
}


