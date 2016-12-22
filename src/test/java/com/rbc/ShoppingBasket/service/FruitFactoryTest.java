package com.rbc.ShoppingBasket.service;

import static org.junit.Assert.*;

import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FruitFactoryTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	final String basePath="src\\test\\resources\\";
	private String testEnumFruitTypesInvalid = "invalidFruitType.txt";
	private String testInvalidPricing = "invalidPriceNegative.txt";
	private String testInvalidPricingCharacter = "invalidPrice.txt";
	private String testInvalidFileFormatting = "invalidFormat.txt";
	private String validFile = "validFruits.txt";
	
	@Before
	public void setUp() {
		testEnumFruitTypesInvalid = getFilePath(testEnumFruitTypesInvalid);
		testInvalidPricing = getFilePath(testInvalidPricing);
		testInvalidPricingCharacter = getFilePath(testInvalidPricingCharacter);
		testInvalidFileFormatting = getFilePath(testInvalidFileFormatting);
		validFile = getFilePath(validFile);

	}

	public String getFilePath(String fileName){
		return Paths.get(basePath+fileName).toAbsolutePath().toString();
	}
	
	@Test
	public void testValidFruitTypes() {
		assertEquals(5,FruitFactory.createBasket(validFile).size());
	}
	
	@Test
	public void testInvalidFruitTypes() {
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("Invalid fruit type ");
		FruitFactory.createBasket(testEnumFruitTypesInvalid);
	}

	@Test
	public void testInvalidPriceNegative() {
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("Product price should be greater than 0 ");
		FruitFactory.createBasket(testInvalidPricing);
	}

	@Test
	public void testInvalidPriceNAN() {
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("Price needs to be a number for ");
		FruitFactory.createBasket(testInvalidPricingCharacter);
	}

	@Test
	public void testInvalidFileFormat() {
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("Seperate fruit and price using character ");
		FruitFactory.createBasket(testInvalidFileFormatting);
	}
	
	@Test
	public void testInvalidFileException() {
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("Error reading file containing basket of items to buy prices ");
		FruitFactory.createBasket("invalid file name");
	}

}