package com.rbc.ShoppingBasket.model;
/**
 * Fruit Object has a type and price
 * The fruit type is defined as an enum - closed set
 * The price is a double
 * 
 * @author ade
 *
 */
public class Fruit {
	    private FruitType fruitType;
	    private double price;

	    public Fruit(FruitType fruitType, double price) {
	        this.fruitType = fruitType;
	        this.price = price;
	    }
	 
	    public FruitType getFruitType() {
	        return fruitType;
	    }

		public double getPrice() {
			return price;
		}
	 
}
