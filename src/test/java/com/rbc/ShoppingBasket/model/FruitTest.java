package com.rbc.ShoppingBasket.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class FruitTest {
	@Test
	public void createApple() {
		Fruit fruit = new Fruit(FruitType.APPLE,0.1);
		assertEquals(FruitType.APPLE, fruit.getFruitType());
		assertEquals(0.1, fruit.getPrice(),0);
	}
	@Test
	public void createBanana() {
		Fruit fruit = new Fruit(FruitType.BANANA,0.2);
		assertEquals(FruitType.BANANA, fruit.getFruitType());
		assertEquals(0.2, fruit.getPrice(),0);
	}
	@Test
	public void createLemon() {
		Fruit fruit = new Fruit(FruitType.LEMON,0.3);
		assertEquals(FruitType.LEMON, fruit.getFruitType());
		assertEquals(0.3, fruit.getPrice(),0);
	}
	@Test
	public void createOrange() {
		Fruit fruit = new Fruit(FruitType.ORANGE,0.4);
		assertEquals(FruitType.ORANGE, fruit.getFruitType());
		assertEquals(0.4, fruit.getPrice(),0);
	}
	@Test
	public void createPeach() {
		Fruit fruit = new Fruit(FruitType.PEACH,0.5);
		assertEquals(FruitType.PEACH, fruit.getFruitType());
		assertEquals(0.5, fruit.getPrice(),0);
	}

}
