package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		
		List <Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = input.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" +  i + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char ch = input.next().charAt(0);
			
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			
			System.out.print("Price: ");
			Double price = input.nextDouble();
			
			if (ch == 'c') {
				Product tag = new Product(name, price);
				list.add(tag);
			}
			
			else if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate manufactureDate = LocalDate.parse(input.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				Product tag = new UsedProduct(name, price, manufactureDate);
				list.add(tag);
			}
			
			else {
				System.out.print("Custom fee: ");
				double customsFee = input.nextDouble();
				
				Product tag = new ImportedProduct(name, price, customsFee);
				list.add(tag);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		for (Product tag : list) {
			System.out.println(tag.priceTag());
		}
		
		input.close();

	}

}
