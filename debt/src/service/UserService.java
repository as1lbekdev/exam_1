package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String FILE_PATH = "users.json";

    private List<User> users = new ArrayList<>();


    public UserService() {
        User superAdmin = new User();
        superAdmin.setName("root");
        superAdmin.setPhoneNumber("99999");
        superAdmin.setPassword("root123");
        superAdmin.setType(2);
        users.add(superAdmin);
    }

    public User getUserByPhone(String phone) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phone)) {
                return user; // shu userni qaytaradi, marketId to‘g‘ri bo‘lsa shu ham bo‘ladi
            }
        }
        return null;
    }


    public User addUser(User user) {



        for (User user1 : users) {
            if(user1.getPhoneNumber().equals(user.getPhoneNumber())) {
                System.out.println("This user already exists");
            }

        }
        users.add(user);
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

    public User login(String phone, String pass)  {

        for (User user : users) {

            if(user.getPhoneNumber().equals(phone) && user.getPassword().equals(pass)) {
                return user;
            }

        }
        return null;
    }
}
