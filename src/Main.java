import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data: ");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Birth date (DD/MM/YYYY): ");
        sc.nextLine();
        String date = sc.next();
        Date birthDate = sdf.parse(date);

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");

        System.out.print("Status: ");
        String status = sc.next();
        OrderStatus orderStatus = OrderStatus.valueOf(status);

        Order order = new Order(new Date(), orderStatus, client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();


            OrderItem item = new OrderItem(productQuantity, productPrice, product);

            order.addItem(item);
        }

        System.out.println();
        System.out.println("ORDER SUMARY:");
        System.out.println(order);

        sc.close();
    }
}