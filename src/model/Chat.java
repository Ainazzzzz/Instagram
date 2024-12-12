package model;

import java.util.Arrays;

public class Chat {
    private User user1;
    private User user2;
    private Message[] messages;

    public Chat(User user1, User user2, Message[] messages) {
        this.user1 = user1;
        this.user2 = user2;
        this.messages = messages;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        for (Message message : messages) {
            System.out.println(message.getSender());
            System.out.println(message.getTime());
            System.out.println(message.getText());
        }
       return "";
    }
}
