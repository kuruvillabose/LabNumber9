//Finny April 2019
package co.grandcircus;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingListApplication {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> item = new ArrayList<>();
		ArrayList<Double> price = new ArrayList<>();
		ArrayList<String> itemOrdered = new ArrayList<>();
		ArrayList<Double> priceOrd = new ArrayList<>();
		
		String prompt = "Y";
		String pitems;

		item.add("apple");
		item.add("banana");
		item.add("cauliflower");
		item.add("dragonfruit");
		item.add("Elderberry");
		item.add("figs");
		item.add("grapefruit");
		item.add("honeydew");

		price.add(0.99);
		price.add(0.59);
		price.add(1.59);
		price.add(2.19);
		price.add(1.79);
		price.add(2.09);
		price.add(1.99);
		price.add(3.49);
		do {
			System.out.println("Welcome to David's Market");
			System.out.println("Item                 Price");
			System.out.println("==========================");
			// for loop to display Array list
			for (int i = 0; i < item.size(); i++) {
				System.out.println(String.format("%-20s %s", item.get(i), price.get(i)));
			}
			boolean f = false;
			int i = 0;
			System.out.println("What Item would you like to order?");
			pitems = scan.next();
			
			try {
				for (i = 0; i < item.size(); i++) {
					if (pitems.equals(item.get(i))) {

						itemOrdered.add(pitems);
						priceOrd.add(price.get(i));
						f = true;
						break;
					}
				}
			} catch (InputMismatchException e) {
				f = false;
			}
			if (f == true)
				System.out.println("Adding " + pitems + " to cart at $" + String.valueOf(price.get(i)));
			else {
				System.out.println("Sorry we dont have those.Please try agaian");
				prompt = "y";
				continue;
			}

			System.out.println("would you like to order anything else...(y/n)");
			prompt = scan.next();

		} while (prompt.equalsIgnoreCase("Y"));

		System.out.println("Thanks for your order!");

		for (int i = 0; i < itemOrdered.size(); i++) {
			System.out.println(String.format("%-10s %s", itemOrdered.get(i), priceOrd.get(i)));
		}
		System.out.println("Average price per item in order was " + averageOfItems(priceOrd, itemOrdered.size()));
		System.out.println("Item with highest cost is " + maxPrice(priceOrd, itemOrdered.size()));
		System.out.println("Item with lowest cost is " + minPrice(priceOrd, itemOrdered.size()));
		scan.close();
	}

	// Method1-Average of items ordered.
	public static double averageOfItems(ArrayList<Double> items, int size) {
		double avg = 0.0;
		for (int i = 0; i < size; i++) {
			avg += items.get(i) / size;
		}
		return avg;
	}
	//Method 2-Item with highest cost
	public static double maxPrice(ArrayList<Double> price, int size) {
		double max = price.get(0);
		for (int i = 0; i < size; i++) {
			
			if(max<price.get(i))
				max=price.get(i);
		}
		return max;
	}
	
	//Method 3-Item with lowest cost
		public static double minPrice(ArrayList<Double> price, int size) {
			double min = price.get(0);
			for (int i = 0; i < size; i++) {
				
				if(min>price.get(i))
					min=price.get(i);
			}
			return min;
		}
}