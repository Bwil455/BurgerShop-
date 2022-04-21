package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public abstract class MenuFood {

	protected enum Type {
		BURGER, SNACK, DRINK, COMBO
	}

	// Change the params passed into the MenuFood to fit that of the combo
	protected String burgerName;
	protected String snackName;
	protected String drinkName;

	protected float burgerPrice;
	protected float snackPrice;
	protected float drinkPrice;

	protected String foodName;
	protected float price;
	protected SIZE size;

	// This is the general constructor, this must be modified for snacks and drinks
	public MenuFood(String burgerName, float burgerPrice, String snackName, float snackPrice, String drinkName,
			float drinkPrice, SIZE size) {

		this.burgerName = burgerName;
		this.burgerPrice = burgerPrice;
		this.snackName = snackName;
		this.snackPrice = snackPrice;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.size = size;

	}

	public MenuFood() {
		// TODO Auto-generated constructor stub
	}

	protected abstract Type getType();

	protected String getName() {
		return foodName;
	}

	protected float getPrice() {
		return price;
	}

	protected SIZE getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	// methods that count number of subclass instances present in arraylist used
//	public int getBurgers() {
//		for 
//	}
}
