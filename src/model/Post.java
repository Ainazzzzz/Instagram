package model;

public class Post {
    private String title;
    private String description;
    private int likes;
    private int dislikes;
    private String[] comments;

    public Post(String title, String description, int likes, int dislikes, String[] comments) {
        this.title = title;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}
