package com.example.weblog.Repository;

import com.example.weblog.Models.Category;
import com.example.weblog.Models.Post;
import com.example.weblog.Models.Tag;
import com.example.weblog.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    public List<Post> findAllByCategory(Category category);

    public List<Post> findAllByUser(User user);

    public List<Post> findAllByTitle(String title);

    public List<Post> findAllByContentContains(String content);

    public List<Post> findAllByUserAndStatus(User user, boolean status);

    public List<Post> findAllByUserAndPublishDateIsAfter(User user, Date afterDate);

    public List<Post> findAllByUserAndPublishDateIsBefore(User user, Date beforeDate);

    public List<Post> findAllByTagsIsContaining(Tag tag);

    public boolean existsByUser(User user);

    public boolean existsByTitleContains(String title);

    public boolean existsByContentContains(String content);
    
}
