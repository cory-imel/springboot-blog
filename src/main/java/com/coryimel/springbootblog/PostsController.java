package com.coryimel.springbootblog;

import com.coryimel.springbootblog.daos.PostsRepository;
import com.coryimel.springbootblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostsController {
    private final PostsRepository postsRepository;
//    private final PostService postService;

    public PostsController(PostsRepository postsRepository) {
//        this.postService = postService;
        this.postsRepository = postsRepository;
    }

    @RequestMapping("/posts")
    public String index(Model viewAndModel) {
//        List<Post> posts = Arrays.asList(
//            new Post("Post A", "Body A"),
//            new Post("Post B", "Body B"),
//            new Post("Post C", "Body C")
//        );

        viewAndModel.addAttribute("posts", postsRepository.findAll());

        return "posts/index";
    }

    @RequestMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewAndModel) {
//        Post post = new Post("Test post", "Test body");

        viewAndModel.addAttribute("post", postsRepository.findOne(id));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/form";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        postsRepository.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable Long id,Model model) {
        model.addAttribute("post", postsRepository.findOne(id));
        model.addAttribute("pageId", id);
        return "/posts/form";
    }

    @PostMapping("/posts/edit")
    public String EditPost(@ModelAttribute Post post,) {
        postsRepository.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String showDeleteForm(@PathVariable Long id,Model model) {
        model.addAttribute("post", postsRepository.findOne(id));
        model.addAttribute("pageId", id);
        return "/posts/form";
    }

    @PostMapping("/posts/delete")
    public String DeletePost(@ModelAttribute Post post){
        postsRepository.delete(post);
        return "redirect:/posts";
    }

}
