import model.Card;
import model.User;
import service.CardService;
import service.UserService;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {


        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        UserService userService = new UserService();
        CardService cardService = new CardService();
        System.out.println("Welcome to PayMe!");


        int stepcode=3;

        while(stepcode!=0){

            System.out.println("""
                      1. Add a new user
                      2. User get all;
                      3. Update user;
                      4.  remove user;
                   
                      6. Exit;
                      """);
            switch (scannerInt.nextInt()){
                case 1:
                    System.out.println("Enter username:");
                    String username = scannerStr.next();


                    System.out.println(" enter your id");
                    String id=scannerStr.next();

                    System.out.println("Enter password:");
                    String password = scannerStr.next();


                    userService.add(new User(username, password));
                    System.out.println(userService.login(username, password)+
                    "User added successfully");


                    if (userService.login(username, password) != null){
                        System.out.println("""
                                  1. Add a new card
                                  2. Get all cards
                                  3. Update card
                                  4. Remove card
                                  5.exits;
                                  """);

                        switch (scannerInt.nextInt()){
                            case 1:


                                System.out.println(" enter your owner name");
                                String ownerName=scannerStr.next();

                                System.out.println("enter card number");
                                String cardNum=scannerStr.next();

                                System.out.println("enter cvv");
                                String cvv=scannerStr.next();
                                cardService.add(new Card(ownerName,cardNum,cvv));
                                 break;
                            case 2:
                                for (Card card : cardService.getAll()) {
                                    System.out.println(card);
                                }
                                break;

                            case 3:
                                if (cardService.getAll().isEmpty()) {
                                    System.out.println("Cards list is empty");
                                }
                                userService.update(UUID.fromString(id),new User());

                            case 4:
                                if (cardService.getAll().isEmpty()) {
                                    System.out.println("Cards list is empty");
                                }

                        }



                    }


                    break;






                case 2:
                    for (User user : userService.getAll()) {
                        System.out.println(user);
                    }
                    break;

                case 3:
                    if (userService.getAll().isEmpty()) {
                        System.out.println("Users list is empty");
                        break;
                    }

                    User user=new User();
                    System.out.println("Enter id:");


                    System.out.println("Enter new username:");
                    user.setUsername(scannerStr.next());

                    System.out.println("Enter new password:");
                    user.setPassword(scannerStr.next());

                    userService.update(user.getId(), user);
                    break;

                case 4:
                    if (userService.getAll().isEmpty()) {
                        System.out.println("Users list is empty");
                    }
                      case 6:

                    return;

            }


            }


        }




    }
