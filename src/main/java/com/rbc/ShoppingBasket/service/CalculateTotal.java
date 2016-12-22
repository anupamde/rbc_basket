package com.rbc.ShoppingBasket.service;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import com.rbc.ShoppingBasket.model.Fruit;
import com.rbc.ShoppingBasket.model.FruitBasket;
/**
 * 
 * Calculate the total price of a basket
 * 
 * @author ade
 *
 */
public class CalculateTotal extends RecursiveTask<Double> {
	private static final long serialVersionUID = 1L;
	// the number of items in a basket for simple processing
	// any number greater than SEQUENTIAL_THRESHOLD does a fork and join
	private static final int SEQUENTIAL_THRESHOLD = 1_000;

	// start and end point index values for processing
	private int low, high;
	// items in basket
	private List<Fruit> fruitList; 

	CalculateTotal(List<Fruit> fruitList, int low, int high) {
		this.fruitList = fruitList;
		this.low   = low;
		this.high  = high;
	}
	
	/**
	 *  Method to calculate the total basket cost
	 *  Small number of items sequentially added
	 *  Large numbers are forked processed and then joined 
	 */
	protected Double compute() {
		// simple processing 
		if(high - low <= SEQUENTIAL_THRESHOLD) {
			Double total = 0d;
			for(int i=low; i < high; ++i) 
				total += fruitList.get(i).getPrice();
			return total;
		} else {
			// large number of items - fork and join
			int mid = low + (high - low) / 2;
			CalculateTotal left  = new CalculateTotal(fruitList, low, mid);
			CalculateTotal right = new CalculateTotal(fruitList, mid, high);
			left.fork();
			double rightAns = right.compute();
			double leftAns  = left.join();
			return leftAns + rightAns;
		}
	}

	/**
	 * Calculate the total cost of basket
	 * Print the total number of items and cost to 2 decimal places
	 * 
	 * @param basket
	 * @return
	 */
	public static double getTotal(FruitBasket basket) {
		List<Fruit> fruitList = basket.getFruitList();
		Double total = ForkJoinPool.commonPool().invoke(new CalculateTotal(fruitList,0,fruitList.size()));
		System.out.println("\nTotal number of items: " +fruitList.size());
		System.out.printf("Total cost is: %.2f", total);
		return total;
	}
}
