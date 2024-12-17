package dao;

import model.Chat;
import model.User;

public interface UserInterface {
     User signIn(String username, String password);
     User signUp(User user);

}
