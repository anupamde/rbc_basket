package com.rbc.ShoppingBasket.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rbc.ShoppingBasket.model.Fruit;
import com.rbc.ShoppingBasket.model.FruitBasket;
import com.rbc.ShoppingBasket.model.FruitType;

public class CalculateTotalTest {
	private FruitBasket basket_small, basket_large; 

	@Before
	public void setUp(){
		List<Fruit> smallfruitList = new ArrayList<Fruit>();
		List<Fruit> largefruitList = new ArrayList<Fruit>();
		
		for (int i=0;i<999;++i){
			smallfruitList.add(new Fruit(FruitType.APPLE,1));
		}
		for (int i=0;i<2000;++i){
			largefruitList.add(new Fruit(FruitType.PEACH,1));
		}

		basket_small = new FruitBasket(smallfruitList);
		basket_large = new FruitBasket(largefruitList);
	}
	
	@Test
	public void checkBasketTotalSimple() {
		assertEquals(999, basket_small.getFruitList().size());
		assertEquals(999, CalculateTotal.getTotal(basket_small),0);
	}
	
	@Test
	public void checkBasketForkJoin() {
		assertEquals(2000, basket_large.getFruitList().size());
		assertEquals(2000, CalculateTotal.getTotal(basket_large),0);
	}
}
