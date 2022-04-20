package nz.ac.auckland.se281.a2;

import java.util.ArrayList;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

public class BurgerShop {

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

		// create a new instance of a burger using the passed in values
		Burgers burger = new Burgers(name, price);

		// add the created burger instance to ArrayList
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

		// Use if else to change the price of the snack according to size
		if (Size == SIZE.L) {
			price = price + 3;
		} else if (Size == SIZE.XL) {
			price = price + 4;
		}

		// creates a new instance of snack and adds to ArrayList
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

		// Adjusts price according to size
		if (Size == SIZE.L) {
			price = price + 3;
		} else if (Size == SIZE.XL) {
			price = price + 4;
		}

		// create instance of drink using passed in values and add to ArrayList
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

		// This value will be used to print the total cost of the cart
		float total = 0;

		// For loop goes through
		for (int i = 0; i < cartArray.size(); i++) {

			// stores the current index of cartArray to be used
			MenuFood print = cartArray.get(i);

			// increments total price as it cycles through each element of cartArray
			total = total + print.price;

			// Prints out the items in the cart per the requirements
			System.out.println(i + " - " + print.foodName + ": $" + String.format("%.02f", print.price));

		}

		// prints out the total amount of the items in the cart
		System.out.println("Total: $" + String.format("%.02f", total));

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
