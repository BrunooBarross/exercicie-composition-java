package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter cliente data:");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY)");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next()); //value of converte a string para o valor de ORder
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many item to this order? ");
		int qtdItems = sc.nextInt();
		
		for(int i = 0; i < qtdItems; i++) {
			System.out.println("Enter #" + i + 1  + " item data:");
			System.out.println("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Product Price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(quantity, productPrice, product);
			
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println(order);
		sc.close();

	}
}
