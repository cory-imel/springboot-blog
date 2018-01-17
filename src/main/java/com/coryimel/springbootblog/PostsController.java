package com.coryimel.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "Posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String post(@PathVariable String id) {
        return "View an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createGet() {
        return "View a post creation form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a post";
    }

}
