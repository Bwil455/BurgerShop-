package nz.ac.auckland.se281.a2;

public class Burgers extends MenuFood {

	public Burgers(String foodName, float price) {
		super();
		this.foodName = foodName;
		this.price = price;

		// TODO Auto-generated constructor stub
	}

	@Override
	protected MenuFood.Type getType() {
		return Type.BURGER;
	}

}
