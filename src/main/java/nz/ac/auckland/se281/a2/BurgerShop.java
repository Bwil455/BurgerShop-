package nz.ac.auckland.se281.a2;

import java.util.ArrayList;

import nz.ac.auckland.se281.a2.MenuFood.Type;
import nz.ac.auckland.se281.a2.cli.Menu.SIZE;
import nz.ac.auckland.se281.a2.cli.MessagesCLI;

public class BurgerShop {

	ArrayList<MenuFood> cartArray = new ArrayList<MenuFood>();

	public BurgerShop() {

	}

	// returns the number of instances of the type passed into method from the
	// cartArray
	public int numType(MenuFood.Type Type) {

		int numOf = 0;

		for (int i = 0; i < cartArray.size(); i++) {

			MenuFood checkType = cartArray.get(i);

			// checks if each element is of the same type as that passed into the method, if
			// so increments counter
			if (checkType.getType() == Type) {
				numOf++;
			}

		}

		return numOf;
	}

	public void calcWaitingTime() {

		int secs;
		int mins;
		int hours;

		int burgers = numType(Type.BURGER);
		int snacks = numType(Type.SNACK);
		int drinks = numType(Type.DRINK);
		int combos = numType(Type.COMBO);

		int totalSecs = 0;

		if (burgers != 0) {
			totalSecs = totalSecs + (300 + ((burgers - 1) * 60));
		}

		if (snacks != 0) {
			totalSecs = totalSecs + (180 + ((snacks - 1) * 30));
		}

		if (drinks != 0) {
			totalSecs = totalSecs + (45 + ((drinks - 1) * 15));
		}

		if (combos != 0) {
			totalSecs = totalSecs + (combos * 525);
		}

		// code adapted from https://stackoverflow.com/a/6118983
		hours = totalSecs / 3600;
		mins = (totalSecs % 3600) / 60;
		secs = (totalSecs % 3600) - (mins * 60);

		String confirmed = MessagesCLI.ESTIMATE_WAITING_TIME.getMessage();

		System.out.print(confirmed);
		System.out.printf("%d hours %d minutes %d seconds", hours, mins, secs);
		System.out.println();

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
	public void addSnack(String name, float price, SIZE size) {

		// Use if else to change the price of the snack according to size
		if (size == SIZE.L) {
			price = price + 3;
		} else if (size == SIZE.XL) {
			price = price + 4;
		}

		// creates a new instance of snack and adds to ArrayList
		Snacks snack = new Snacks(name, price, size);

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
	public void addDrink(String name, float price, SIZE size) {

		// Adjusts price according to size
		if (size == SIZE.L) {
			price = price + 3;
		} else if (size == SIZE.XL) {
			price = price + 4;
		}

		// create instance of drink using passed in values and add to ArrayList
		Drinks drink = new Drinks(name, price, size);

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

		// Variable used to check if there are any elements in cartArray
		boolean empty = cartArray.isEmpty();

		// If else statement to change output depending on if cart is empty or not
		if (empty == true) {

			// print error message if cart empty
			MessagesCLI.CART_EMPTY.printMessage();

		} else {

			// Iterates through the cartArray, stores current element in print variable
			for (int i = 0; i < cartArray.size(); i++) {

				MenuFood print = cartArray.get(i);

				// stores the price of a combo into a single variable, then added to total if
				// need be
				float comboPrice = (float) (print.burgerPrice + print.snackPrice + (0.50 * print.drinkPrice));
				// adds up the total of the cart as it goes
				total = total + print.price + comboPrice;

				// if else statement changes printed output depending on whether the current
				// element is of type drink/snack or burger or combo, prints out the according
				// message
				if (print.getType() == Type.DRINK || print.getType() == Type.SNACK) {

					System.out.println(i + " - " + print.foodName + " " + "(" + print.size + ")" + ": $"
							+ String.format("%.02f", print.price));

				} else if (print.getType() == Type.BURGER) {

					System.out.println(i + " - " + print.foodName + ": $" + String.format("%.02f", print.price));
				} else if (print.getType() == Type.COMBO) {

					System.out.println(i + " - COMBO : (" + print.burgerName + ", " + print.snackName + " ("
							+ print.size + "), " + print.drinkName + " (" + print.size + ")): $"
							+ String.format("%.02f", comboPrice));
				}
			}

			// final if else statement adjusts printing the total cost depending on
			// if a discount has been applied or not
			if (total > 100.00) {

				MessagesCLI.DISCOUNT.printMessage();

				// adjusts total with 25% discount then prints total
				total = (float) (total - (total * 0.25));

				System.out.println("Total: $" + String.format("%.02f", total));

			} else if (total < 100.00) {

				// prints total
				System.out.println("Total: $" + String.format("%.02f", total));

			}

		}

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

		// change the size of both the snack and the drink depending on size input from
		// user then add to cartArray
		if (size == SIZE.L) {
			priceSnack = priceSnack + 3;
			priceDrink = priceDrink + 3;

		} else if (size == SIZE.XL) {
			priceSnack = priceSnack + 4;
			priceDrink = priceDrink + 4;
		}

		// Create new instance of Combo
		Combo combo = new Combo(nameBurger, priceBurger, nameSnack, priceSnack, nameDrink, priceDrink, size);

		cartArray.add(combo);
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

		// if statement, checks whether posCart is a valid index (then returns error
		// message) if not removes from cart
		if (posCart < 0 || posCart >= cartArray.size()) {
			MessagesCLI.NOT_VALID_CART_POSITION.printMessage();
		} else {
			cartArray.remove(posCart);
		}
	}

	/**
	 * removes all elements in the cart
	 */
	public void clearCart() {

		cartArray.removeAll(cartArray);

	}

	/**
	 * This method confirms the order, showing the estimated pick up time. It also
	 * give a warning if there are missing opportunities for COMBO menus
	 * 
	 * @param burgersFound
	 * 
	 */
	public void confirmOrder() {

		// set variables that will count amount of instances of respective types
		int burgers = 0;
		int snacks = 0;
		int drinks = 0;

		// used to check if there is a combo opportunity
		int comboOp = 0;

		// if cart empty error message
		if (cartArray.isEmpty()) {
			MessagesCLI.ORDER_INVALID_CART_EMPTY.printMessage();
		} else {

			// finds the amount of each subclass (this will be used to calculate waiting
			// time)
			burgers = numType(Type.BURGER);
			snacks = numType(Type.SNACK);
			drinks = numType(Type.DRINK);

			// contains at least 1 possibility of a combo
			if (burgers > 0 && snacks > 0 && drinks > 0) {

				// ArrayLists to contain
				ArrayList<Integer> positionSnack = new ArrayList<Integer>();
				ArrayList<Integer> positionDrink = new ArrayList<Integer>();

				// for loops adds the elements that contain the respective types in their
				// arraylists
				for (int i = 0; i < cartArray.size(); i++) {
					MenuFood current = cartArray.get(i);

					if (current.getType() == Type.SNACK) {
						positionSnack.add(i);
					} else if (current.getType() == Type.DRINK) {
						positionDrink.add(i);
					}
				}

				// embedded for loop compares each elements size, if same size will prevent the
				// order and display error message
				for (int j = 0; j < positionSnack.size(); j++) {
					for (int k = 0; k < positionDrink.size(); k++) {

						int snackEle = positionSnack.get(j);
						int drinkEle = positionDrink.get(k);

						MenuFood snack = cartArray.get(snackEle);
						MenuFood drink = cartArray.get(drinkEle);

						if (snack.size == drink.size) {
							comboOp = 1;

						}
					}
				}

				// If statement uses comboOp to determine the output
				if (comboOp == 0) {

					showCart();
					calcWaitingTime();
					clearCart();
				} else if (comboOp == 1) {
					MessagesCLI.MISSED_COMBO.printMessage();

				}

				// If cart was valid/ no opportunity for a potential combo then prints waiting
				// time and clears cart
			} else {
				showCart();
				calcWaitingTime();
				clearCart();
			}

		}

	}
}
