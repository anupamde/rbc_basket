package com.rbc.ShoppingBasket;

import java.util.List;

import com.rbc.ShoppingBasket.model.Fruit;
import com.rbc.ShoppingBasket.model.FruitBasket;
import com.rbc.ShoppingBasket.service.CalculateTotal;
import com.rbc.ShoppingBasket.service.FruitFactory;
/**
 * Main class to process a file containing product and price
 * Once created - read a file containing a list of products(basket) - process that file and output total price
 * @author ade
 *
 */
public class ShoppingBasket {
	public static void main(String args[]){
			String fruitBasketFile = args[0]; //"G:\\workspace_neon\\RBC_Basket\\src\\main\\resources\\fruit_price2.txt";
			List<Fruit> fruits = FruitFactory.createBasket(fruitBasketFile);
			FruitBasket fruitBasket = new  FruitBasket(fruits);
			CalculateTotal.getTotal(fruitBasket);
	}
}
