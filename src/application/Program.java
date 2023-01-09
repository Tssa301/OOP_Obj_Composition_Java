package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();

        System.out.print("Email: ");
        String clientEmail = sc.nextLine();

        System.out.print("Birth date (DD/MM/YY): ");
        Date clientBday = sdf.parse(sc.next());

        Client client = new Client(clientName,clientEmail, clientBday);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(),status,client);

        System.out.print("How many items for this order? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++){
            System.out.println("Enter #" + i + " item data:");
            sc.nextLine();
            System.out.print("Product name: ");
            String prodName = sc.nextLine();

            System.out.print("Product price: ");
            double prodPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(prodName, prodPrice);
            OrderItem item = new OrderItem(quantity, prodPrice,product);
            order.addItems(item);
        }
        sc.close();

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

    }
}
