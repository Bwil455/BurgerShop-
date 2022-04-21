package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public abstract class MenuFood {

	public enum Type {
		BURGER, SNACK, DRINK
	}

	public String foodName;
	public float price;
	public SIZE Size;

	// This is the general constructor, this must be modified for snacks and drinks
	public MenuFood(String foodName, float price, SIZE Size) {

		this.foodName = foodName;
		this.price = price;
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
}
