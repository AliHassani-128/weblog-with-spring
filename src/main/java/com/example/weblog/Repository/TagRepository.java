package com.example.weblog.Repository;

import com.example.weblog.Models.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagRepository extends MongoRepository<Tag, String> {
    public List<Tag> findAllByName(String name);

    public Tag findTagByName(String name);

    public boolean existsByName(String name);

}
