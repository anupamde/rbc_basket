#rbc
	Requirement:
	Write a program that takes a basket of items and outputs its total cost
	The basket can contain one or more of the following items: Bananas, Oranges, Apples, Lemons, Peaches.
	
	
	This application has been created on Java 1.8
	It uses maven to build the application
	Also uses Junit for running tests
	
	RBC_Basket-1.0.0-SNAPSHOT.jar - jar file checked in under root folder
	To run use command: 
	java -jar RBC_Basket-1.0.0-SNAPSHOT.jar <file name to process>

	File to process - please use following valid format (valid fruit type>:<numeric price greater than 0>, example below
	Apple:0.1
	Banana:0.3
	Peach:1.02
	Apple:0.1	
	Lemon:0.5
	Orange:12


	Junit tests: Package details 
					 src/test/java/com/rbc/ShoppingBasket/
	
	Main class:  com/rbc/ShoppingBasket/ShoppingBasket.java
					
	Model:			 com/rbc/ShoppingBasket/model/FruitBasket.java
					 com/rbc/ShoppingBasket/model/Fruit.java
					 com/rbc/ShoppingBasket/model/FruitType.java
					 
	Service:		 com/rbc/ShoppingBasket/service/CalculateTotal.java
					 com/rbc/ShoppingBasket/service/FruitFactory.java
					 		