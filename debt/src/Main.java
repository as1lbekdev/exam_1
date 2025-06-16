import model.Debt;
import model.Market;
import model.User;
import service.DebtService;
import service.MarketService;
import service.UserService;

import java.io.File;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        UserService userService = new UserService();
        DebtService debtService = new DebtService();
        MarketService marketService = new MarketService();
        Market market = new Market();
        market.setId(UUID.randomUUID());
        market.setName("SuperMarket");
        marketService.addMarket(market);
        System.out.println("Market created: " + market.getId());

        int stepCode = 10;
        while (stepCode != 0) {
            System.out.println("1. Add user, 2. Login, 0.Exit");
            stepCode = scannerInt.nextInt();
            scannerInt.nextLine();

            switch (stepCode) {
                case 1 -> {
                    User user = new User();
                    user.setId(UUID.randomUUID());

                    System.out.println("Enter your username:");
                    user.setName(scannerString.nextLine());

                    System.out.println("Enter your password:");
                    user.setPassword(scannerString.nextLine());

                    System.out.println("Enter your phone number:");
                    user.setPhoneNumber(scannerString.nextLine());

                    user.setType(0);
                    userService.addUser(user);
                    System.out.println("User added successfully.");
                }
                case 2 -> {
                    System.out.println("Enter your phone number:");
                    String phoneNumber = scannerString.nextLine();

                    System.out.println("Enter your password:");
                    String password = scannerString.nextLine();

                    User currentUser = userService.login(phoneNumber, password);

                    if (currentUser == null) {
                        System.out.println("Login failed! Incorrect phone number or password.");
                        break;
                    }

                    if (currentUser.getType() == 2) {
                        int stepcode2 = 10;
                        while (stepcode2 != 0) {
                            System.out.println("1. CLIENT -> CASSER, 0. Exit");
                            stepcode2 = scannerInt.nextInt();
                            scannerInt.nextLine();

                            switch (stepcode2) {
                                case 1 -> {
                                    System.out.print("Enter phone number of user to promote: ");
                                    String userPhone = scannerString.nextLine();

                                    User userToPromote = userService.getUserByPhone(userPhone);

                                    if (userToPromote == null) {
                                        System.out.println("User not found");
                                    } else {
                                        userToPromote.setType(1);
                                        userToPromote.setMarketId(market.getId());
                                        System.out.println(userToPromote.getName() + " is now a casser");
                                    }
                                }
                                case 0 -> System.out.println("Exiting super admin menu");
                                default -> System.out.println("Invalid option");
                            }
                        }
                    } else if (currentUser.getType() == 1) {
                        int stepcode3 = 10;
                        while (stepcode3 != 0) {
                            System.out.println("1. GET MY DEBTS, 0. Exit");
                            stepcode3 = scannerInt.nextInt();
                            scannerInt.nextLine();

                            switch (stepcode3) {
                                case 1 -> {
                                    Debt[] debts = debtService.currentUserDebts(currentUser.getId());
                                    if (debts.length == 0) {
                                        System.out.println("You have no debts.");
                                    } else {
                                        for (Debt debt : debts) {
                                            Market m = marketService.getMarketById(debt.getMarketId());
                                            String mName = (m != null) ? m.getName() : "Unknown Market";
                                            System.out.println("Market: " + mName + ", Amount: " + debt.getAmount());
                                        }
                                    }
                                }
                                case 0 -> System.out.println("Exiting user menu");
                                default -> System.out.println("Invalid option");
                            }
                        }
                    } else {
                        int stepcode4 = 10;
                        while (stepcode4 != 0) {
                            System.out.println("1. Add Debt, 0. Exit");
                            stepcode4 = scannerInt.nextInt();
                            scannerInt.nextLine();

                            switch (stepcode4) {
                                case 1 -> {
                                    System.out.print("Enter debt amount: ");
                                    double amount = scannerInt.nextDouble();
                                    scannerInt.nextLine();
                                    debtService.addDebt(currentUser.getId(), market.getId(), amount);
                                    System.out.println("Debt added successfully.");
                                }
                                case 0 -> System.out.println("Exiting...");
                                default -> System.out.println("Invalid option");
                            }
                        }
                    }
                }
                case 0 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid option");
            }
        }

        scannerInt.close();
        scannerString.close();
    }
}
