package dao.impl;

import dao.UserInterface;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserInterfaceImpl implements UserInterface {
    private List<User> users = new ArrayList<>();

    public UserInterfaceImpl(User[] initialUsers) {
        for (User user : initialUsers) {
            users.add(user);
        }
    }

    @Override
    public User signIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // если не найден
    }

    @Override
    public User signUp(User user) {
        users.add(user); // добавляем нового пользователя
        return user;
    }
}
