package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class Combo extends MenuFood {

	public String burgerName;
	public String snackName;
	public String drinkName;

	public float burgerPrice;
	public float snackPrice;
	public float drinkPrice;

	public Combo(String burgerName, float burgerPrice, String snackName, float snackPrice, String drinkName,
			float drinkPrice, SIZE Size) {
		super(burgerName, burgerPrice, snackName, snackPrice, drinkName, drinkPrice, Size);

	}

	public Combo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MenuFood.Type getType() {
		// TODO Auto-generated method stub
		return Type.COMBO;
	}

	public SIZE getSize() {
		return Size;
	}

}
