package com.cg.fda.service;

 

import static org.assertj.core.api.Assertions.assertThat;

 

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.fda.domain.FoodCart;
import com.cg.fda.domain.Order;
import com.cg.fda.exception.IDNotFoundException;
import com.cg.fda.repository.FoodCartRepository;
import com.cg.fda.repository.OrderRepository;

 

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    @MockBean
    private OrderRepository orderRepository;
    @Test
    void createOrder() {
        Order order=new Order();
        order.setorderId(1);
        order.setUserName("Sandhya");
        order.setUserPhone("9121393187");
        order.setUserEmailId("chatu@gmail.com");
        order.setUserAddress("Tirupathi");
               Mockito.when(orderRepository.save(order)).thenReturn(order);
        assertThat(adminService.createOrder(order)).isEqualTo(order);
            
        }
    @Test
    void deleteOrderTest() throws IDNotFoundException {
        Order order=new Order();
        order.setorderId(1);
        order.setUserName("Sandhya");
        order.setUserPhone("9121393187");
        order.setUserEmailId("chatu@gmail.com");
        order.setUserAddress("Tirupathi");
        int orderId=order.getOrderId();
        Assert.assertTrue(orderRepository.findById(3).isEmpty());                     
    }    
    @Test
    void getAllOrder() throws IDNotFoundException {
        Order order=new Order();
        order.setorderId(1);
        order.setUserName("Sandhya");
        order.setUserPhone("9121393187");
        order.setUserEmailId("chatu@gmail.com");
        order.setUserAddress("Tirupathi");
        int orderId=order.getOrderId();
      //  Mockito.when(orderRepository.findAll()).thenReturn(orderlist);
     //   assertThat(paymentService.viewPaymentDetailsById(paymentId)).isEqualTo(payment);
        List<Order> orderlist = new ArrayList<>();
        Mockito.when(orderRepository.findAll()).thenReturn(orderlist);
		assertThat(adminService.getAllOrder()).isEqualTo(orderlist);
        
    }

  /*  @Test
    void getAllPaymentsTest () {
        Payment payment=new Payment();
        payment.setId(2);
        payment.setPaymentMode("giftCard");
        payment.setCardNumber("12212348");
        payment.setCardHolderName("jayasree");
        payment.setExpiryDate("09/03/2022");
        payment.setCvv(321);
        payment.setOtp(1234);
        Payment payment2=new Payment();
        payment2.setId(3);
        payment2.setPaymentMode("promo code");
        payment2.setCardNumber("12212348");
        payment2.setCardHolderName("jayasree");
        payment2.setExpiryDate("09/03/2022");
        payment2.setCvv(321);
        payment2.setOtp(1234);
        List<Payment> paymentList=new ArrayList<Payment>();
        paymentList.add(payment2);
        paymentList.add(payment);
        Mockito.when(paymentRepository.findAll()).thenReturn(paymentList);
        assertThat(paymentService.getAllPayments()).isEqualTo(paymentList);
        
    }
}*/
@MockBean
private FoodCartRepository foodcartRepository;
@Test
void createFoodCart() {
    FoodCart foodcart=new FoodCart();
    foodcart.setFoodCartId(1);
    foodcart.setRestaurantName("Chillies");
    foodcart.setFoodItemName("Pizza");
    foodcart.setFoodItemQuantity("7");
              Mockito.when(foodcartRepository.save(foodcart)).thenReturn(foodcart);
    assertThat(adminService.createFoodCart(foodcart)).isEqualTo(foodcart);
        
    }
@Test
void deleteFoodCartTest() throws IDNotFoundException {
	 FoodCart foodcart=new FoodCart();
	    foodcart.setFoodCartId(1);
	    foodcart.setRestaurantName("Chillies");
	    foodcart.setFoodItemName("Pizza");
	    foodcart.setFoodItemQuantity("7");
    int foodcartId=foodcart.getFoodCartId();
    Assert.assertTrue(foodcartRepository.findById(3).isEmpty());                     
}    
@Test
void getAllFoodCart() throws IDNotFoundException {
	 FoodCart foodcart=new FoodCart();
	    foodcart.setFoodCartId(1);
	    foodcart.setRestaurantName("Chillies");
	    foodcart.setFoodItemName("Pizza");
	    foodcart.setFoodItemQuantity("7");

    int foodcartId=foodcart.getFoodCartId();
  //  Mockito.when(orderRepository.findAll()).thenReturn(orderlist);
 //   assertThat(paymentService.viewPaymentDetailsById(paymentId)).isEqualTo(payment);
    List<Order> orderlist = new ArrayList<>();
    Mockito.when(orderRepository.findAll()).thenReturn(orderlist);
	assertThat(adminService.getAllOrder()).isEqualTo(orderlist);
    
}
}

 