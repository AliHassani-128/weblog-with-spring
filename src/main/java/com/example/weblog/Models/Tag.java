package com.example.weblog.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class Tag {

    @Id
    @Field("_id")
    @JsonIgnore
    private String id;

    @Indexed(unique = true)
    @NotBlank
    @Size(min = 5, max = 60)
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
