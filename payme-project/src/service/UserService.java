package service;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService implements BaseService<User> {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    @Override
    public User add(User user) {
        if (!exists(user.getUsername())) {
            users.add(user);
            return user;
        }
        return null;
     }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User update(UUID id, User user) {
        User found = getById(id);
        if (found != null) {
            found.setUsername(user.getUsername());
            found.setPassword(user.getPassword());
        }
        return found;
    }

    @Override
    public void remove(UUID id) {
        User found = getById(id);
        if (found != null) {
            found.setActive(false);
        }
    }

    @Override
    public User getById(UUID id) {
        for (User u : users) {
            if (u.isActive() && id.equals(u.getId())) {
                return u;
            }
        }
        return null;
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.isActive() && username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }
    private boolean exists(String username) {
        for (User u : users) {
            if (u.isActive() && username.equals(u.getUsername())) {
                return true;
            }
        }
        return false;
    }
}
