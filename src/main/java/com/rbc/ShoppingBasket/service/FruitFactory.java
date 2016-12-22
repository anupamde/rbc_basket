package com.rbc.ShoppingBasket.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rbc.ShoppingBasket.model.Fruit;
import com.rbc.ShoppingBasket.model.FruitType;
/**
 * 
 * This class will create a List of fruits from a file
 * The file will contain valid fruits and valid numeric prices.
 * This data will be parsed and entered into List
 * 
 * @author ade
 *
 */
public class FruitFactory {
	
	// File content separator fruit type:price - Apple:1.9
	private final static String SEPERATOR = ":";

	/**
	 * Ensure price is extracted and is numeric
	 * @param lineValue
	 * @return
	 */
	private static double extractPrice(String lineValue) {
		try { 
			return Double.parseDouble(lineValue.split(SEPERATOR)[1]);
		} catch (NumberFormatException e){
			throw new IllegalArgumentException("Price needs to be a number for "  +lineValue);
		} catch (ArrayIndexOutOfBoundsException e){
			throw new IllegalArgumentException("Seperate fruit and price using character "+SEPERATOR +" for " +lineValue);
		}
	}
	
	/**
	 * This method is to validate file input
	 * Parse each line in the list, extract fruit type and price
	 * Ensure fruit type is listed in enum
	 * Ensure price is numeric and greater than 0
	 * 
	 * @param fruitPricesFromFile
	 * @return
	 */
    private static List<Fruit> createFruits(List<String> fruitPricesFromFile) {
    	List<Fruit> fruits = new ArrayList<Fruit>();

    	// validate price is greater than 0 and valid fruit type
    	fruitPricesFromFile.forEach(lineItem->{
    		String fruitType = lineItem.split(SEPERATOR)[0];
    		double price = extractPrice(lineItem);
    		if (price > 0d){
				try { 
					FruitType validFruitType = FruitType.valueOf(fruitType);
			    	Fruit fruit = new Fruit(validFruitType,price);
			    	fruits.add(fruit);
				}catch(Exception e){
					throw new IllegalArgumentException("Invalid fruit type "+fruitType );
				}
			}else{
				throw new IllegalArgumentException("Product price should be greater than 0 for " +fruitType);
			}
    	});
		return fruits;
    }
    
    /**
     * 
     * This method is to load file date into an ArrayList
     * 
     * Process the file - line by line
     * Ensure the line is not empty, then trim spaces
     * and upper case to match FruitType enums
     * 
     * Create a array list of Strings to create a List of fruit objects
     * 
     * @param basketFileData
     * @return
     */
	public static List<Fruit> createBasket(String basketFileData) {
		List <String> fruitsInBasket = new ArrayList<String>();
		try{
			fruitsInBasket = Files.lines(Paths.get(basketFileData))
					.filter(s -> !s.isEmpty())
					.map(String::trim).map(String::toUpperCase)
					.collect(Collectors.toList());
		} catch (IOException e) {
			throw new IllegalArgumentException("Error reading file containing basket of items to buy prices " +basketFileData+"\n" +e);
		} 
		return createFruits(fruitsInBasket);
	}
}