package server.models;

import org.json.simple.JSONObject;

import java.util.ArrayList;
public class Message {
    private int id;
    private String text;
    private String postDate;
    private String author;

    public Message(int id, String text, String postDate, String author) {
        this.id = id;
        this.text = text;
        this.postDate = postDate;
        this.author = author;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", postDate='" + postDate + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
    public static ArrayList<Message> messages = new ArrayList<Message>();


    public static int nextId() {
        int id = 0;
        for (Message m : messages) {
            if (m.getID() > id) {
                id = m.getID();
            }
        }
        return id + 1;
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject j = new JSONObject();
        j.put("id", getID());
        j.put("text", getText());
        j.put("postDate", getPostDate());
        j.put("author", getAuthor());
        return j;
    }

}
