package com.example.weblog.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document("Post")
public class Post {

    @Id
    @Field("_id")
    @JsonIgnore
    private String id;
    @Indexed(unique = true)
    @NotBlank
    private User user;
    private Category category;
    @Indexed(unique = true)
    @NotBlank
    private String title;
    private String content;
    private boolean status;
    private Date publishDate;
    private long like;
    private long disLike;
    private String image;
    private Tag[] tags;
    private Comment[] comments;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public long getLike() {
        return this.like;
    }

    public void setLike(long like) {
        this.like = like;
    }

    public long getDisLike() {
        return this.disLike;
    }

    public void setDisLike(long disLike) {
        this.disLike = disLike;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Tag[] getTags() {
        return this.tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public Comment[] getComments() {
        return this.comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
}
