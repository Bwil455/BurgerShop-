package nz.ac.auckland.se281.a2;

import java.util.ArrayList;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class BurgerShop {

	// Make instances of the menu items according to subclass
	// THis is a long way to do it so will comment this out for now
//	Burgers zero = new Burgers("Cheese Burger", (float) 15.50);
//	Burgers one = new Burgers("Avocado Burger", (float) 17.00);
//	Burgers two = new Burgers("Vegan Burger", (float) 18.50);
//	Burgers three = new Burgers("Fisherman Burger", (float) 17.00);
//	Burgers four = new Burgers("Buffalo Chicken Burger", (float) 13.00);
//	Burgers five = new Burgers("Black Truffle Bruger", (float) 27.50);
//	Burgers six = new Burgers("Crispy Froe Gras Burger", (float) 34.00);
//
//	Snacks seven = new Snacks("Chips", (float) 7.50);
//	Snacks eight = new Snacks("Sweet Potato Chips", (float) 10.00);
//	Snacks nine = new Snacks("Onion Rings", (float) 5.00);
//	Snacks ten = new Snacks("Buffalo Chicken Wings", (float) 12.00);
//	Snacks eleven = new Snacks("Fish Fingers", (float) 8.00);
//
//	Drinks twelve = new Drinks("Coke", (float) 2.00);
//	Drinks thirteen = new Drinks("Sprite", (float) 2.00);
//	Drinks fourteen = new Drinks("Fanta", (float) 2.00);
//	Drinks fifteen = new Drinks("Milkshake", (float) 4.00);

	ArrayList<MenuFood> cartArray = new ArrayList<MenuFood>();

	public BurgerShop() {

	}

	/**
	 * Add a burger in the cart
	 * 
	 * @param name
	 * @param price
	 */
	public void addBurger(String name, float price) {

		Burgers burger = new Burgers(name, price);

		cartArray.add(burger);

	}

	/**
	 * add a snack in the cart, if size is L the price should be incremented by $3
	 * if the size is XL the price should be incremented by $4 (@see
	 * nz.ac.auckland.se281.a2.cli.Menu.SIZE)
	 * 
	 * 
	 * @param name
	 * @param price
	 * @param size
	 */
	public void addSnack(String name, float price, SIZE Size) {

		if (Size == SIZE.L) {
			price = price + 3;
		} else if (Size == SIZE.XL) {
			price = price + 4;
		}

		Snacks snack = new Snacks(name, price, Size);

		cartArray.add(snack);
	}

	/**
	 * 
	 * add a drink in the cart
	 * 
	 * if size is L the price should be incremented by $3 if the size is XL the
	 * price should be incremented by $4 (@see
	 * nz.ac.auckland.se281.a2.cli.Menu.SIZE)
	 * 
	 *
	 * @param name
	 * @param price
	 * @param size
	 */
	public void addDrink(String name, float price, SIZE Size) {

		if (Size == SIZE.L) {
			price = price + 3;
		} else if (Size == SIZE.XL) {
			price = price + 4;
		}

		Drinks drink = new Drinks(name, price, Size);

		cartArray.add(drink);
	}

	/**
	 * print the content of the cart, or print MessagesCLI.CART_EMPTY if the cart is
	 * empty
	 * 
	 * @param String
	 *
	 *
	 */
	public void showCart() {

		float total = 0;

		for (int i = 0; i < cartArray.size(); i++) {

			MenuFood data = cartArray.get(i);

			total = total + data.price;

			String num = String.format("%.02f", data.price);

			System.out.println(i + " - " + data.foodName + ": $" + num);

		}

		System.out.println(String.format("%.02f", total));

	}

	/**
	 * add a combo in the cart.
	 * 
	 * The price of a combo is the sum of all the items, but the drink would be half
	 * price. Note that in a combo, both snacks and drinks have the same size, and
	 * the combo price must consider the size (@see addSnack and addDrink methods).
	 * 
	 * @param nameBurger
	 * @param priceBurger
	 * @param nameSnack
	 * @param priceSnack
	 * @param nameDrink
	 * @param priceDrink
	 * @param size
	 */
	public void addCombo(String nameBurger, float priceBurger, String nameSnack, float priceSnack, String nameDrink,
			float priceDrink, SIZE size) {
		// TODO TASK2
	}

	/**
	 * remove the item in the cart specified by the position posCart. Note that the
	 * position of the cart start from zero. if postCart is invalid: posCart < 0 OR
	 * posCart >= size of the cart the method prints
	 * MessagesCLI.NOT_VALID_CART_POSITION
	 * 
	 * @param posCart
	 */
	public void removeItem(int posCart) {
		// TODO TASK3
	}

	/**
	 * removes all elements in the cart
	 */
	public void clearCart() {
		// TODO TASK3
	}

	/**
	 * This method confirms the order, showing the estimated pick up time. It also
	 * give a warning if there are missing opportunities for COMBO menus
	 * 
	 */
	public void confirmOrder() {
		// TODO TASK4
	}
}
