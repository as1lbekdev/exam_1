package uz.pdp;

import uz.pdp.model.*;
import uz.pdp.service.*;

import java.io.IOException;
import java.util.Scanner;

import static uz.pdp.model.UserType.ADMIN;
import static uz.pdp.model.UserType.USER;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    static UserService userService = new UserService();
    static ProductMarkerService productMakerService = new ProductMarkerService();
    static ProductService productService = new ProductService();
    static CartService cartService = new CartService();
    static CategoryService categoryService = new CategoryService();

    public static void main(String[] args) throws IOException {
        int step = 10;
        while (step != 0) {
            System.out.println("1.Registor   2.Login    0.Exit");
            step = scannerInt.nextInt();
            switch (step) {
                case 1 -> {
                    System.out.print(" Ismingizni kiriting:");
                    String name = scannerStr.nextLine();
                    System.out.print(" Username kiriting:");
                    String userName = scannerStr.nextLine();
                    System.out.print(" Passwordingizni kiriting:");
                    String password = scannerStr.nextLine();
                    userService.add(new User(name, userName, password, USER));
                }
                case 2 -> {
                    System.out.print(" usernameni kiriting:");
                    String username = scannerStr.nextLine();
                    System.out.print(" password kiriting:");
                    String password = scannerStr.nextLine();
                    User currUser = userService.login(username, password);
                    if (currUser == null) {
                        System.out.println("Parol yoki Username xato qayta kiriting !!! ");
                    }else{
                        login(currUser);
                    }
                }
            }
        }
    }

    public static void login(User currUser) {
        if (currUser.getTypeUser().equals(ADMIN)){
            int step = 10;
            while (step != 0) {
                System.out.println("""
                        1. Add Category
                        2. Get Category by Id
                        3. Delete Category
                        4. Add Product
                        5. Get Product
                        6. Delete Product
                        0. Exit
                        """);
                step = scannerInt.nextInt();
                switch (step) {
                    case 1 -> {
                        System.out.println(" qaysi categoriyaga qo`shmoqchisz:");
                        String cName = scannerStr.nextLine();
                        System.out.println(" Yangi categoriya nameni kiriting:");
                        String name = scannerStr.nextLine();
                         Category category = categoryService.getByName(cName);
                        categoryService.addCategory(new Category(name,category.getId()),cName);
                    }
                    case 2 -> {}
                    case 3 -> {}
                    case 4 -> {
                        System.out.println("qaysi categoryga qo`shmoqchisz :");
                        String cName = scannerStr.nextLine();
                        System.out.println("Product Nameni kiriting :");
                        String name = scannerStr.nextLine();
                        System.out.println("Product narxini kiriting :");
                        double price = scannerInt.nextDouble();
                        Category category = categoryService.getByName(cName);
                        productService.addProduct(new Product(category.getId(),name,price),category.getId());
                    }
                    case 5 -> {}
                    case 6 -> {}
                }
            }
        }
        else {
            int step = 10;
            while (step != 0) {
                System.out.println("""
                        1. Create Cart
                        2. Get Cart
                        3. Get all Cart
                        0. Exit
                        """);
                step = scannerInt.nextInt();
                switch (step) {
                    case 1 -> {}
                    case 2 -> {}
                    case 3 -> {}
                }
            }
        }
    }
}