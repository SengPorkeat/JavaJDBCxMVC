package view;

import controller.CustomerController;
import mapper.CustomerMapper;
import model.dao.CustomerDaoImpl;
import model.dao.OrderDaoImpl;
import model.entity.Customer;
import model.entity.Order;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private final CustomerController customerController = new CustomerController();
    public static void addMenu(){
        System.out.println("=".repeat(23)+"| Add System |"+"=".repeat(23));
        System.out.println("1. Add new customer");
        System.out.println("2. Add new order");
        System.out.println("=".repeat(60));
        System.out.print("Choose your option: ");
        int op = new Scanner(System.in).nextInt();
        System.out.println("=".repeat(60));
        switch (op) {
            case 1->{}
            case 2->{
                System.out.print("Order Name: ");
                String orderName = new Scanner(System.in).nextLine();
                System.out.print("Order Description: ");
                String orderDescription = new Scanner(System.in).nextLine();
                new OrderDaoImpl().addNewOrder(new Order(1,
                        orderName,
                        orderDescription,
                        Customer.builder()
                                .id(8)
                                .build(),
                        new ArrayList<>(),
                        Date.valueOf(LocalDate.now())));

            }
        }
    }
    public static void showAll(){
        System.out.println("=".repeat(23)+"| Add System |"+"=".repeat(23));
        System.out.println("1. Show all customer");
        System.out.println("2. Show all order");
        System.out.println("=".repeat(60));
        System.out.print("Choose your option: ");
        int op = new Scanner(System.in).nextInt();
        System.out.println("=".repeat(60));
        switch (op) {
            case 1->
                new CustomerDaoImpl().queryAllCustomers()
                        .stream()
                        .map(CustomerMapper::mapCustomerToCustomerDto)
                        .forEach(System.out::println);
            case 2-> new OrderDaoImpl().queryAllOrders().forEach(System.out::println);
        }
    }
    public static void delete(){
        System.out.println("=".repeat(22)+"| Delete System |"+"=".repeat(21));
        System.out.println("1. Delete customer");
        System.out.println("2. Delete order");
        System.out.println("=".repeat(60));
        System.out.print("Choose your option: ");
        int op = new Scanner(System.in).nextInt();
        System.out.println("=".repeat(60));
        switch (op) {
            case 1-> {
                System.out.print("Delete by ID: ");
                int id = new Scanner(System.in).nextInt();
                new CustomerDaoImpl().deleteCustomerById(id);
            }
            case 2-> {
                System.out.print("Delete by ID: ");
                int id = new Scanner(System.in).nextInt();
                new OrderDaoImpl().deleteOrderById(id);
            }
        }
    }
    public static void update(){
        System.out.println("=".repeat(22)+"| Update System |"+"=".repeat(21));
        System.out.println("1. Update customer");
        System.out.println("2. Update order");
        System.out.println("=".repeat(60));
        System.out.print("Choose your option: ");
        int op = new Scanner(System.in).nextInt();
        System.out.println("=".repeat(60));
        switch (op) {
            case 1-> {
                System.out.print("Update by ID: ");
                int id = new Scanner(System.in).nextInt();
                new CustomerDaoImpl().updateCustomerById(id);
            }
            case 2-> {
                System.out.print("Update by ID: ");
                int id = new Scanner(System.in).nextInt();
                new OrderDaoImpl().updateOrder(id);
            }
        }
    }
    public static void menu(){
        System.out.println("=".repeat(20)+"| Customer Service |"+"=".repeat(20));
        System.out.println("1. Show all customer");
        System.out.println("2. Add new customer");
        System.out.println("3. Update customer");
        System.out.println("4. Delete customer");
        System.out.println("0. Exit");
        while (true) {
            System.out.println("=".repeat(60));
            System.out.print("Choose your option: ");
            int op = new Scanner(System.in).nextInt();
            System.out.println("=".repeat(60));
            switch (op) {
                case 1-> showAll();
                case 2-> addMenu();
                case 3-> update();
                case 4-> delete();
                case 0-> System.exit(0);
            }
        }
    }
}
