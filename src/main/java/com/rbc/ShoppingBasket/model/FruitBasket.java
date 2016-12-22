package com.rbc.ShoppingBasket.model;

import java.util.List;
/**
 * Fruit basket contains a list of fruits
 * Each fruit object will have type of fruit and its price
 * @author ade
 *
 */
public class FruitBasket {
	private List<Fruit> fruitList;

	public List<Fruit> getFruitList() {
		return fruitList;
	}

	public FruitBasket(List<Fruit> fruitList) {
		super();
		this.fruitList = fruitList;
	}
}
