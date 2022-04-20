package nz.ac.auckland.se281.a2;

public class Burgers extends MenuFood {

	public Burgers(String foodName, float price) {
		super();
		this.foodName = foodName;
		this.price = price;

		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return foodName;
	}

	@Override
	public float getPrice() {
		return price;
	}

}
