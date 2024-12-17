import java.util.ArrayList;
import java.util.List;

public class Post {
    String content;
    List<String> comments = new ArrayList<>();

    Post(String content) {
        this.content = content;
    }

    void addComment(String comment) {
        comments.add(comment);
    }

    List<String> getComments() {
        return comments;

    }
}