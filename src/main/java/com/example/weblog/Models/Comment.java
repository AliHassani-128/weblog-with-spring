package com.example.weblog.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Comment")
public class Comment {

    @Id
    @Field("_id")
    @JsonIgnore
    private String id;

    private User user;
    private String content;
    private Comment answer;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment getAnswer() {
        return this.answer;
    }

    public void setAnswer(Comment answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return this.content;

    }

}
