package uz.pdp;

import uz.pdp.model.User;
import uz.pdp.service.*;

import java.util.Scanner;

import static uz.pdp.model.UserType.ADMIN;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    static UserService userService = new UserService();
    static ProductMarkerService productMakerService = new ProductMarkerService();
    static ProductService productService = new ProductService();
    static CartService cartService = new CartService();
    static CategoryService categoryService = new CategoryService();

    public static void main(String[] args) {
        int step = 10;
        while (step != 0) {
            System.out.println("1.Registor   2.Login    0.Exit");
            step = scannerInt.nextInt();
            switch (step) {
                case 1 -> {}
                case 2 -> {
                    System.out.println("Enter username");
                    String userName = scannerStr.nextLine();
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
                        2. Get Category
                        3. Delete Category
                        4. Add Product
                        5. Get Product
                        6. Delete Product
                        0. Exit
                        """);
                step = scannerInt.nextInt();
                switch (step) {
                    case 1 -> {}
                    case 2 -> {}
                    case 3 -> {}
                    case 4 -> {}
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