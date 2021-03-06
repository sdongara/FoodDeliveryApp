package com.cg.fda.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "FOOD_CART")
public class FoodCart {

	@ApiModelProperty(notes = "Id of the Food Cart", name="foodCartId", required=true, value="Food Cart Id")
	@Id
	@Column(name = "food_cart_id", nullable = false)
	//@NotBlank(message= "Food cart Id cannot be null")
	//@Size(min=4,max=5,message="Size must be between 4 to 5 characters")
	private int foodCartId;	
	
	@ApiModelProperty(notes = "Name of the Restaurant", name="restaurantName", required=true, value="Restaurant Name")
	@Column(name = "restaurant_name", nullable = false)
	private String restaurantName;
	
	
	@ApiModelProperty(notes = "Name of the Food Item", name="foodItemName", required=true, value="Food Item Name")
	@Column(name = "food_item_name", nullable = false)
	private String foodItemName;
	
	
	@ApiModelProperty(notes = "Quantity", name="foodItemQuantity", required=true, value="Food Item Quantity")
	@Column(name = "food_item_quantity", nullable = false)
	//@NotBlank(message= "Food cart Id cannot be null")
	//@Size(min=4,max=5,message="Size must be between 1 to 2 characters")
	private String foodItemQuantity;
	
	

	public FoodCart() {
		
	}

	
	public FoodCart(int foodCartId,String restaurantName, String foodItemName,
			String foodItemQuantity) {
		super();
		this.foodCartId = foodCartId;
		this.restaurantName = restaurantName;
		this.foodItemName = foodItemName;
		this.foodItemQuantity = foodItemQuantity;
	}


	public int getFoodCartId() {
		return foodCartId;
	}


	public void setFoodCartId(int foodCartId) {
		this.foodCartId = foodCartId;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public String getFoodItemName() {
		return foodItemName;
	}


	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}


	public String getFoodItemQuantity() {
		return foodItemQuantity;
	}


	public void setFoodItemQuantity(String foodItemQuantity) {
		this.foodItemQuantity = foodItemQuantity;
	}
}


