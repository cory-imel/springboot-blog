package com.coryimel.springbootblog;

import com.coryimel.springbootblog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts = new ArrayList<>();

    public PostService() {

        createPosts();
    }
    public List<Post> findAll() {
        return posts;
    }

    public void save(Post post) {
        post.setId((long)(posts.size() + 1));
        posts.add(post);
    }

    public void edit(Post post) {
//        post.setId((long)(posts.size() + 1));
//        posts.set(post.getId().intValue(),post);
//        System.out.println(post.getBody());
        posts.add(post);
    }

    public Post findOne(long id) {
        return posts.get((int)(id - 1));
    }

    public void createPosts() {
        save(new Post(
                "Post1",
                "Some stuff"
        ));
        save(new Post(
                "Post2",
                "Some stuff"
        ));
        save(new Post(
                "Post3",
                "Some stuff"
        ));
        save(new Post(
                "Post4",
                "Some stuff"
        ));
    }
}
