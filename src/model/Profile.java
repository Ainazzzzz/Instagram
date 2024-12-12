package model;

import java.util.Arrays;

public class Profile {
    private String avatar;
    private User[] followers; // подписчики
    private User[] following; //подписки
    private Post[] posts;
    private Chat[] chats;

    public Profile(String avatar, User[] followers, User[] following, Post[] posts) {
        this.avatar = avatar;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public User[] getFollowers() {
        return followers;
    }

    public void setFollowers(User[] followers) {
        this.followers = followers;
    }

    public User[] getFollowing() {
        return following;
    }

    public void setFollowing(User[] following) {
        this.following = following;
    }

    public Post[] getPosts() {
        return posts;
    }

    public void setPosts(Post[] posts) {
        this.posts = posts;
    }

    public Chat[] getChats() {
        return chats;
    }

    public void setChats(Chat[] chats) {
        this.chats = chats;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "avatar='" + avatar + '\'' +
                ", followers=" + Arrays.toString(followers) +
                ", following=" + Arrays.toString(following) +
                ", posts=" + Arrays.toString(posts) +
                '}';
    }
}
