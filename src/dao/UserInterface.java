package dao;

import model.User;

public interface UserInterface {
     User signIn(String username, String password);
     User signUp(User user);
}
