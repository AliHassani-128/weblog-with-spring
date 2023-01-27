package com.example.weblog.Repository;

import com.example.weblog.Models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {
    public List<Category> findAllByName(String name);

    public Boolean existsByName(String name);

    public List<Category> findAllByParent(Category parent);

}
