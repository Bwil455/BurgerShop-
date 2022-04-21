package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class Snacks extends MenuFood {

	public Snacks(String foodName, float price, SIZE Size) {
		super(foodName, price, Size);
		this.Size = Size;

	}

	@Override
	public MenuFood.Type getType() {
		return Type.SNACK;
	}

	public float getPrice() {
		return price;
	}

	public SIZE getSize() {
		return Size;
	}

}
