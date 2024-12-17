package dao.impl;

import dao.UserInterface;
import model.Chat;
import model.User;

import java.lang.reflect.Array;


public class UserInterfaceImpl implements UserInterface {
    private User[] users;

    public UserInterfaceImpl(User[] users) {
        this.users = users;
    }

    @Override
    public User signIn(String username, String password) {
       for (User user : users) {
           if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
               return user;
           }
       }
           return null;
    }



    @Override
    public User signUp(User user) {
        return null;
    }



    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }
}
