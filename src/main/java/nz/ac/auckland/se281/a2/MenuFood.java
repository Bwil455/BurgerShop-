package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public abstract class MenuFood {

	public enum Type {
		BURGER, SNACK, DRINK, COMBO
	}

	// Change the params passed into the MenuFood to fit that of the combo
	public String burgerName;
	public String snackName;
	public String drinkName;

	public float burgerPrice;
	public float snackPrice;
	public float drinkPrice;

	public String foodName;
	public float price;
	public SIZE Size;

	// This is the general constructor, this must be modified for snacks and drinks
	public MenuFood(String burgerName, float burgerPrice, String snackName, float snackPrice, String drinkName,
			float drinkPrice, SIZE Size) {

		this.burgerName = burgerName;
		this.burgerPrice = burgerPrice;
		this.snackName = snackName;
		this.snackPrice = snackPrice;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.Size = Size;

	}

	public abstract Type getType();

	public MenuFood() {
		// TODO Auto-generated constructor stub
	}

	// Two getters just for general purpose
	public String getName() {
		return foodName;
	}

	public float getPrice() {
		return price;
	}

	public SIZE getSize() {
		// TODO Auto-generated method stub
		return null;
	}
}
