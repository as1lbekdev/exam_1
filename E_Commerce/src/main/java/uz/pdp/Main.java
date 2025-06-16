package uz.pdp;

import uz.pdp.model.*;
import uz.pdp.service.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static uz.pdp.model.UserType.ADMIN;
import static uz.pdp.model.UserType.USER;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    static UserService userService = new UserService();
    static ProductService productMakerService = new ProductService();
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
        if (currUser.getTypeUser().equals(USER)){
            int step = 10;
            while (step != 0) {
                System.out.println("""
                        1. Add Category
                        2. Get ChildCategory By Id
                        3. Delete Category
                        4. Add Product
                        5. Get Product
                        6. Delete Product
                        0. Exit
                        """);
                step = scannerInt.nextInt();
                switch (step) {
                    case 1 -> {
                        List<Category> categories = categoryService.getALLCategories();
                        for (Category category : categories) {
                            System.out.println(category);
                        }
                        System.out.println("""
                                Qaysi kategoriyaga qo'shmoqchisiz ?
                                Id kiriting :
                                Bosh kategoriya uchun : 1
                                """);
                        String id = scannerStr.nextLine();
                        Category category = new Category();
                        System.out.println("Kategoriya nomi: ");
                        String name = scannerStr.nextLine();
                        category.setName(name);
                        category.setCreatedById(currUser.getId());
                        try {
                            int i = Integer.parseInt(id);
                            if (i == 1) {
                                categoryService.addCategory(category);
                            }
                        }
                        catch (Exception e) {
                            UUID uuid = UUID.fromString(id);
                            categoryService.addCategory(category, uuid);
                        }
                    }
                    case 2 -> {
                        List<Category> categories = categoryService.getALLCategories();
                        for (Category category : categories) {
                            System.out.println(category);
                        }
                        System.out.println(" Id kiriting");
                        UUID id = UUID.fromString(scannerStr.nextLine());
                        List<Category> childCategory = categoryService.getChildCategoryById(id);
                        for (Category category : childCategory) {
                            System.out.println(category);
                        }
                    }
                    case 3 -> {
                        System.out.println(" Id kiriting");
                        UUID id = UUID.fromString(scannerStr.nextLine());
                        System.out.println(categoryService.deleted(id));
                    }
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
                    case 1 -> {

                        UUID userId = currUser.getId();

                        List<Product> productList = productMakerService.getAllProducts();
                        if (productList.isEmpty()) {
                            System.out.println("Hozircha mahsulot mavjud emas");
                            break;
                        }

                        System.out.println("Mahsulotlar:");

                        for (int i = 0; i < productList.size(); i++) {
                            Product product = productList.get(i);
                            System.out.println((i + 1) + ". " + product.getProductName() + " | price: " + product.getPrice());
                        }

                        System.out.print("Qaysi mahsulot ? Raqam kiriting: ");
                        int productIndex = scannerInt.nextInt();

                        if (productIndex < 1 || productIndex > productList.size()) {
                            System.out.println("Noto‘g‘ri raqam tanlandi!");
                            break;
                        }
                        Product selectedProduct = productList.get(productIndex - 1);
                        UUID productId = selectedProduct.getId();

                        System.out.print("Nechta mahsulot qo‘shmoqchisiz? ");
                        int quantity = scannerInt.nextInt();

                        String response = cartService.addProductToCart(productId, userId, quantity);
                        System.out.println(response);
                    }
                    case 2 -> {
                        UUID userId = currUser.getId();
                        Cart cart = cartService.getCartByUserId(userId);



                        if(cart==null){
                            System.out.println(" cart topilmadi");
                        }
                        else{

                            List<Product> productList = productMakerService.getAllProducts();
                            System.out.println(" cart topildi");
                            for (Product product : productList) {

                                System.out.println(product);
                            }
                        }
                    }
                    case 3 -> {

                        List<Cart> carts = cartService.getAllCarts();
                        if (carts.isEmpty()) {
                            System.out.println("Cart is empty");
                        } else {
                            for (Cart cart : carts) {
                                System.out.println(cart);
                            }
                        }
                    }

                }
            }
        }
    }
}