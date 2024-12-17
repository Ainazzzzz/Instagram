package dao;

import model.Chat;
import model.Message;
import model.Profile;

public interface ProfileInterface {
    Chat[]  addChat(Profile profile , Chat  chat);
    Message[] sendMessage(Profile profile, Chat chat, String message); // кто отправляет
    Message[] deleteMessage(Chat chat, int index);
    Chat[] deleteChat(Profile profile, Chat[] oldChats, int indexOf);
    Message[] changeTheText(Chat chat, int indexOf, String newText);
}
