package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class Drinks extends MenuFood {

	public Drinks(String foodName, float price, SIZE Size) {
		super();

		this.foodName = foodName;
		this.price = price;
		this.Size = Size;

	}

	public String getName() {
		return foodName;
	}

	public float getPrice() {
		return price;
	}

	public SIZE getSize() {
		return Size;
	}

	@Override
	public MenuFood.Type getType() {
		return Type.DRINK;
	}

}
