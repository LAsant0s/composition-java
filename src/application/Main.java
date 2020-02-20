package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
//		sc.useLocale(Locale.US);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		// part one: reading and storing client data
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine(); 
		System.out.print("Email: ");
		String email = sc.nextLine(); 
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		sc.nextLine();
		
		
		Client client = new Client(name, email, birthDate); 
		//end of part one
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		Order order = new Order(new Date(), status, client);
		Double numero = sc.nextDouble();
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=1 ; i<=n ; i++) {
			
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product's name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product's price: ");
			Double price = sc.nextDouble();
			
			Product product = new Product(productName, price); 
			
			System.out.print("Quantity: ");
			Integer quant = sc.nextInt();
			
			OrderItem item = new OrderItem(quant, price, product); 
			order.addItem(item);
		}
		System.out.println();
		System.out.println(order.toString());	
	
	}

}
