import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Eshkere {
    List<User> users = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Eshkere app = new Eshkere();
        app.run();
    }
    void run() {
        User user1 = new User("aisulu");
        user1.addPost(new Post("i am natural"));
        user1.addPost(new Post("i am not natural"));
        users.add(user1);
        User user2 = new User("tilek");
        user2.addPost(new Post("The mother of DRAGONS!!!!"));
        users.add(user2);
        System.out.println("Выберите пользователя, чтобы посмотреть его посты:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).username);
        }
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < users.size()) {
            User selectedUser = users.get(choice);
            System.out.println("Посты пользователя " + selectedUser.username + ":");
            for (int i = 0; i < selectedUser.getPosts().size(); i++) {
                Post post = selectedUser.getPosts().get(i);
                System.out.println((i + 1) + ". " + post.content);
            }
            System.out.println("Выберите пост для комментирования:");
            int postChoice = scanner.nextInt() - 1;
            if (postChoice >= 0 && postChoice < selectedUser.getPosts().size()) {
                Post selectedPost = selectedUser.getPosts().get(postChoice);
                System.out.println("Комментарий к посту: " + selectedPost.content);
                System.out.print("Введите ваш комментарий: ");
                scanner.nextLine();
                String comment = scanner.nextLine();
                selectedPost.addComment(comment);
                System.out.println("Комментарий добавлен!");
                System.out.println("Комментарии к посту:");
                for (String c : selectedPost.getComments()) {
                    System.out.println("- " + c);
                }
            } else {
                System.out.println("Неверный выбор поста.");
            }
        } else {
            System.out.println("Неверный выбор пользователя.");
        }
    }
}