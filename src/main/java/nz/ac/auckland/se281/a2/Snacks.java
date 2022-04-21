package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class Snacks extends MenuFood {

	public Snacks(String foodName, float price, SIZE size) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.size = size;

	}

	@Override
	protected MenuFood.Type getType() {
		return Type.SNACK;
	}

}
