package dao.impl;

import dao.ChatInterface;
import model.Chat;
import model.Message;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ChatInterfaceImpl implements ChatInterface {
    Scanner scanner = new Scanner(System.in);
    @Override
    public Message addMessage() {
        String text = scanner.nextLine();
        LocalDateTime time  = LocalDateTime.now();
        String sender;
        return null;
    }
}
