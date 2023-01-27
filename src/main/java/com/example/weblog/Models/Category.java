package com.example.weblog.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Category")
public class Category {

    @Id
    @Field("_id")
    @JsonIgnore
    private String id;
    private Category parent;
    private String name;

    public Category getParent() {
        return this.parent;
    }

    public void setParent(Category category) {
        this.parent = category;
    }

    public String getName() {
        return this.name;

    }

    public void setName(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return this.name;
    }
}
