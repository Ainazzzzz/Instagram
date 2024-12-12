package model;

import java.time.LocalDateTime;

public class Message {
    private String text;
    private LocalDateTime time;
    private String sender;

    public Message(String text, LocalDateTime time, String sender) {
        this.text = text;
        this.time = time;
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "model.Message{" +
                "text='" + text + '\'' +
                ", time=" + time +
                ", sender='" + sender + '\'' +
                '}';
    }
}
