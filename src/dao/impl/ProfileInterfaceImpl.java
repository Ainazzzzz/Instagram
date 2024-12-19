package dao.impl;

import dao.ProfileInterface;
import model.Chat;
import model.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;
import model.*;


public class ProfileInterfaceImpl implements ProfileInterface {




    @Override
    public Chat[] addChat(Profile profile, Chat chat) {
        Chat[] newChats = Arrays.copyOf(profile.getChats(), profile.getChats().length + 1 );
        newChats[newChats.length - 1 ] = chat;
        profile.setChats(newChats);
        return newChats;
    }

    @Override
    public Message[] sendMessage(User user, Chat chat, String message) {
        Message[] allMessages = chat.getMessages();


        Message[] newMessages = Arrays.copyOf(allMessages, allMessages.length + 1);


        newMessages[newMessages.length - 1 ] = new Message(message,
                LocalDateTime.now(),
                user.getUsername());

        chat.setMessages(newMessages);

        return newMessages;
    }

    @Override
    public Message[] deleteMessage(Chat chat, int index) {
        Message[] oldMessages = chat.getMessages();
        Message[] newMessages = new Message[oldMessages.length - 1 ];

        for (int i = 0; i < oldMessages.length; i++) {
            if ( i != index) {
                int newIndex = i < index ? i : i - 1;
                newMessages[newIndex] = oldMessages[i];
            }
        }
        chat.setMessages(newMessages);
        return newMessages;
    }

    @Override
    public Chat[] deleteChat(Profile profile,Chat[] oldChats, int indexOf) {

//        Chat[] oldChats = profile.getChats();
//        Chat[] newChats = new Chat[oldChats.length - 1];

//        System.out.println(Arrays.toString(oldChats));
//        System.out.println(Arrays.toString(newChats));

        Chat[] newChats = new Chat[oldChats.length -1 ];


        for (int i = 0; i < oldChats.length; i++) {
            if (i  != indexOf){
                int newIndex = i < indexOf ? i : i - 1;
                newChats[newIndex] = oldChats[i];
            }
        }

        profile.setChats(newChats);

        return newChats;
    }

    @Override
    public Message[] changeTheText(Chat chat, int indexOf, String newText) {
        chat.getMessages()[indexOf].setText(newText);
        return chat.getMessages();

    }


}
