import java.util.ArrayList;
import java.util.List;

public class User {
    String username;
    List<Post> posts = new ArrayList<>();

    User(String username) {
        this.username = username;
    }

    void addPost(Post post) {
        posts.add(post);
    }

    List<Post> getPosts() {
        return posts;
    }
}