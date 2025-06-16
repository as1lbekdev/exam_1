import java.util.ArrayList;
import java.util.List;

public class Main2 {
    private static final List<User> users = List.of(
            new User("Pahlovon ", "pahlavon"),
            new User("Akhror ", "akhror"),
            new User("Sarvar ", "sarvar")
    );

    private static final List<User> newUsers = new ArrayList<>(users);

    public static void main(String[] args) {
        String username = "akhrorooo";
        String fullName = "Sharof";

        User user = getUser(username);
        if (user != null) {
            user.setFullName(fullName);
        }else {
            user = new User(fullName, username);
            newUsers.add(user);
        }
        System.out.println(user);
        System.out.println(newUsers);
    }

    private static User getUser(String username) {
        for (User user: newUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }
}
