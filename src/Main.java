import dao.ChatInterface;
import dao.PostInterface;
import dao.ProfileInterface;
import dao.UserInterface;
import dao.impl.ChatInterfaceImpl;
import dao.impl.PostInterfaceImpl;
import dao.impl.ProfileInterfaceImpl;
import dao.impl.UserInterfaceImpl;
import model.*;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ProfileInterface profileInterface = new ProfileInterfaceImpl();
    static PostInterface postInterface = new PostInterfaceImpl();
    static ChatInterface chatInterface = new ChatInterfaceImpl();
    public static void main(String[] args) {

        User nurlan = new User("nurlan", "password1", "nurlan@gmail.com",
                new Profile("NurlanAvatar", new User[]{}, new User[]{}, new Post[]{}));

        User aisuluu = new User("aisuluu", "password2", "aisuluu@gmail.com",
                new Profile("AisuluuAvatar", new User[]{}, new User[]{}, new Post[]{}));

        User tilek = new User("tilek", "password3", "tilek@gmail.com",
                new Profile("TilekAvatar", new User[]{}, new User[]{}, new Post[]{}));


        User aidana = new User(
                "aidana",
                "password04",
                "aidana28177288@gmail.com",
                new Profile("AidanaAvatar", new User[]{}, new User[]{}, new Post[]{})
        );





        nurlan.getProfile().setFollowers(new User[]{aisuluu, tilek});
        nurlan.getProfile().setFollowing(new User[]{aisuluu});

        aisuluu.getProfile().setFollowers(new User[]{nurlan});
        aisuluu.getProfile().setFollowing(new User[]{tilek});

        tilek.getProfile().setFollowers(new User[]{aisuluu});
        tilek.getProfile().setFollowing(new User[]{nurlan});

        aidana.getProfile().setFollowers(new User[]{aisuluu, nurlan, tilek});
        aidana.getProfile().setFollowers(new User[]{aisuluu, nurlan, tilek});


        Post post1 = new Post("Жаңы күн", "Бүгүн абдан жакшы күн болду!", 10, 2, new String[]{"Супер!", "Сонун экен!"});
        Post post2 = new Post("Достук", "Достук бул баарынан жогору.", 15, 1, new String[]{"Макулмун", "Дагы жазгыла!"});
        Post post3 = new Post("Aidana", "Hello everyone", 4, 0 , new String[]{"Hello",  "Hi"});

        nurlan.getProfile().setPosts(new Post[]{post1});
        aisuluu.getProfile().setPosts(new Post[]{post2});
        aidana.getProfile().setPosts(new Post[]{post3});


        Message message1 = new Message("Салам, кандайсың?", LocalDateTime.now(), "nurlan");
        Message message2 = new Message("Жакшы, рахмат!", LocalDateTime.now(), "aisuluu");

        Chat chat1 = new Chat(nurlan, aisuluu, new Message[]{message1, message2});

        nurlan.getProfile().setChats(new Chat[]{chat1});
        aisuluu.getProfile().setChats(new Chat[]{chat1});

        aidana.getProfile().setChats(new Chat[]{});
        tilek.getProfile().setChats(new Chat[]{});


        Message aidanaToAisuluu1 = new Message("Привет, как дела",
                LocalDateTime.of(
                        LocalDateTime.now().getYear(),
                        LocalDateTime.now().getMonth(),
                        LocalDateTime.now().getDayOfMonth(),
                        8,
                        33
                ),
                "aidana");

        Message aisuluuToAidana1 = new Message("Привет, отлично у теяб как  ? ",
                LocalDateTime.of(
                        LocalDateTime.now().getYear(),
                        LocalDateTime.now().getMonth(),
                        LocalDateTime.now().getDayOfMonth(),
                        9,
                        33
                ),
                "aisuluu");

        Message aidanaToAisuluu2 = new Message("Отлично, какие новости ? ",
                LocalDateTime.of(
                        LocalDateTime.now().getYear(),
                        LocalDateTime.now().getMonth(),
                        LocalDateTime.now().getDayOfMonth(),
                        10,
                        01
                ),
                "aidana");

        Message aisuluuToAidana2 = new Message("Ой новостей нету, всё как обычно ",
                LocalDateTime.of(
                        LocalDateTime.now().getYear(),
                        LocalDateTime.now().getMonth(),
                        LocalDateTime.now().getDayOfMonth(),
                        10,
                        12
                ),
                "aisuluu");

        Chat chat2 = new Chat(
                aidana,
                aisuluu,
                new Message[]{
                        aidanaToAisuluu1,
                        aisuluuToAidana1,
                        aidanaToAisuluu2,
                        aisuluuToAidana2
                }
        );



        UserInterface userInterface = new UserInterfaceImpl(new User[]{nurlan, aisuluu, tilek, aidana});

        Scanner scanner = new Scanner(System.in);

        while (true) {
            getSignInMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введи свой ник:");
                    String username = scanner.next();
                    System.out.println("Введи свой пароль:");
                    String password = scanner.next();
                    User user = userInterface.signIn(username, password);
                    if (user == null) {
                        System.out.println("Такого человека в системе нет!");
                        break;
                    }
                    while (true) {
                        getProfileMenu();
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println(user.getProfile());
                                break;
                            case 2:
                                for (int i = 0; i < user.getProfile().getFollowers().length; i++) {
                                    System.out.println(i + " " + user.getProfile().getFollowers()[i].getUsername());
                                }
                                break;
                            case 3:
                                for (int i = 0; i < user.getProfile().getFollowing().length; i++) {
                                    System.out.println(i + " " + user.getProfile().getFollowing()[i].getUsername());
                                    
                                }
                                break;
                                case 4:
                                    for (int i = 0; i < user.getProfile().getPosts().length; i++) {
                                        System.out.println(i);
                                        System.out.println("Название - " + user.getProfile().getPosts()[i].getTitle());
                                        System.out.println("Описание - "+user.getProfile().getPosts()[i].getDescription());
                                        System.out.println("Комментарии - "+Arrays.toString(user.getProfile().getPosts()[i].getComments()));
                                        System.out.println("Лайки - "+user.getProfile().getPosts()[i].getLikes());
                                        System.out.println("Дизлайки - "+user.getProfile().getPosts()[i].getDislikes());

                                    }
                                    break;
                                    case 5:
                                        boolean isTrue = true;
                                        for (int i = 0; i < user.getProfile().getChats().length; i++) {
                                            System.out.println(i);
                                            System.out.println(user.getProfile().getChats()[i].getUser1().getUsername());
                                        }
                                        System.out.println("Выбери какой чат хочешь открыть:");
                                        choice = scanner.nextInt();
                                        Chat chat = user.getProfile().getChats()[choice];
                                        System.out.println(chat);
                                        while (isTrue) {
                                            getChatsMenu();

                                            choice = scanner.nextInt();
                                            switch (choice) {
                                                case 1:
                                                    System.out.println("Напишите смс");

                                                    scanner.nextLine();
                                                    String text = scanner.nextLine();


                                                    Message[] messages = profileInterface.sendMessage(
                                                            user.getProfile(),
                                                            chat,
                                                            text);

                                                    chat.setMessages(messages);

                                                    System.out.println(Arrays.toString(user.getProfile().getChats()[choice].getMessages()));

                                                    break;
                                                case 2:
                                                    System.out.println("Какой смс хотите удалить по индексу");
                                                    System.out.println(Arrays.toString(chat.getMessages()));
                                                    int index = scanner.nextInt();

                                                    Message[] deletedMessages = profileInterface.deleteMessage(chat, index);

                                                    System.out.println(chat);
                                                    break;
                                                case 3:
                                                    System.out.println("Введите индекс чата ");
                                                    int indexOfDeleted = scanner.nextInt();

                                                    Chat[] deletedChat = profileInterface.deleteChat(
                                                            user.getProfile(),
                                                            user.getProfile().getChats(),
                                                            indexOfDeleted);

//                                                    System.out.println(user.getProfile().getChats());
                                                    System.out.println(Arrays.toString(deletedChat));
                                                    break;
                                                case 4:
                                                    System.out.println(Arrays.toString(chat.getMessages()));
                                                    System.out.println("Введите индекс");
                                                    int indexOf = scanner.nextInt();
                                                    System.out.println("Введите текст");
                                                    scanner.nextLine();
                                                    String newText = scanner.nextLine();
                                                    Message[] changesMessages = profileInterface.changeTheText(chat, indexOf, newText);
                                                    System.out.println(Arrays.toString(chat.getMessages()));
                                                    break;
                                                case 5:
                                                    isTrue = false;
                                                    break;
                                            }
                                        }

                                        break;
                            
                             case 6:
                                Chat[] chats = user.getProfile().getChats();
                                String[] followersAndFollowingNames = new String[user.getProfile().getFollowers().length + user.getProfile().getFollowing().length];
                                int count = 0;
                                for (int i = 0; i < user.getProfile().getFollowers().length; i++) {
                                    for (int a = 0; a < chats.length; a++) {
                                        if (!chats[a].getUser1().getUsername().equals(user.getProfile().getFollowers()[i].getUsername())) {
                                            System.out.println(i + ". " + user.getProfile().getFollowers()[i].getUsername());
                                            followersAndFollowingNames[count] = user.getProfile().getFollowers()[i].getUsername();
                                            count++;
                                        }
                                    }
                                }
                                for (int j = 0; j < user.getProfile().getFollowing().length; j++) {
                                    for (int a = 0; a < chats.length; a++) {
                                        if (!chats[a].getUser1().getUsername().equals(user.getProfile().getFollowing()[j].getUsername())) {
                                            System.out.println(j + ". " + user.getProfile().getFollowing()[j].getUsername());
                                            followersAndFollowingNames[count] = user.getProfile().getFollowing()[j].getUsername();
                                            count++;
                                        }
                                    }
                                }
                                System.out.println("Выбери с кем хочешь начать чат: ");
                                System.out.println(Arrays.toString(followersAndFollowingNames));
                                choice = scanner.nextInt();
                                User findUser = userInterface.getUserByName(followersAndFollowingNames[choice]);
                                Chat newChat = new Chat(findUser, user, new Message[0]);

                                Chat[] newChat1 = Arrays.copyOf(findUser.getProfile().getChats(), findUser.getProfile().getChats().length + 1);
                                newChat1[newChat1.length - 1] = newChat;
                                findUser.getProfile().setChats(newChat1);

                                Chat[] newChat2 = Arrays.copyOf(user.getProfile().getChats(), user.getProfile().getChats().length + 1);
                                newChat2[newChat2.length - 1] = newChat;
                                user.getProfile().setChats(newChat2);
                                 break;



                        }

                    }
                case 2:
                    System.out.println("Для регистрации введите свою почту:");
                    String email = scanner.next();
                    System.out.println("Придумай ник:");
                    String username1 = scanner.next();
                    System.out.println("Придумай пароль:");
                    String password1 = scanner.next();

                    User user1 = userInterface.signUp(new User(username1, email, password1, null));
                    break;


            }

        }
    }

    public static void getSignInMenu() {
        System.out.println("""
                Добро пожаловать в соц сеть ИНСТАГРАМ
                1. Логин
                2. Регистрация
                """);
    }

    public static void getProfileMenu() {
        System.out.println("""
                1. Профиль
                2. Подписчики 
                3. Подписки
                4. Посты
                5. Директ
                6. Начать новый чат
                7. Подписаться
                8. Выйти из аккаунта
                """);

    }

    public static void getChatsMenu(){
        System.out.println("""
                1.Отправить смс
                2.Удалить смс
                3.Удалить чат
                4.Изменить смс
                5. Меню
                """);
    }
}