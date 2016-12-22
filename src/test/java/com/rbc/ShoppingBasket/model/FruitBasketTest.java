package com.rbc.ShoppingBasket.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FruitBasketTest {
	private FruitBasket basket; 

	@Before
	public void setUp(){
		List<Fruit> fruitList = new ArrayList<Fruit>();
		fruitList.add(new Fruit(FruitType.APPLE,0.1));
		fruitList.add(new Fruit(FruitType.BANANA,0.2));
		fruitList.add(new Fruit(FruitType.LEMON,0.3));
		fruitList.add(new Fruit(FruitType.ORANGE,0.4));
		fruitList.add(new Fruit(FruitType.PEACH,0.5));
		basket = new FruitBasket(fruitList);
	}
	
	@Test
	public void checkBasketSize() {
		assertEquals(5, basket.getFruitList().size());
	}
}
