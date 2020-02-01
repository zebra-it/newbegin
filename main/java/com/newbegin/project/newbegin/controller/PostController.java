package com.newbegin.project.newbegin.controller;

import com.newbegin.project.newbegin.model.Post;
import com.newbegin.project.newbegin.model.Tag;
import com.newbegin.project.newbegin.model.User;
import com.newbegin.project.newbegin.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping
    public String showPost(Model model) {
        Iterable<Post> posts = postService.showAll();

        model.addAttribute("posts", posts);
        return "posts";
    }


    @PostMapping("/newpost")
    public String addPost(@AuthenticationPrincipal User user,
                          @Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = ControllerUtil.getErrors(result);

            model.mergeAttributes(errorMap);
            model.addAttribute("post", post);
        } else {
            postService.addNewPost(post, user, model);
        }

        Iterable<Post> posts = postService.showAll();
        model.addAttribute("posts", posts);
        return "posts";
    }


    @PostMapping("/newtag")
    public String addTag(@RequestParam String textTag, Model model) {

        Iterable<Tag> tags = postService.showTag();

        model.addAttribute("tags", tags);
        return "posts";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable long id, Model model) {
        postService.delete(id);

        Iterable<Post> posts = postService.showAll();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @GetMapping("/details/{id}")
    public String get(@PathVariable("id") long id, Model model) {
        postService.find(id)
                .ifPresent(post -> model.addAttribute("post", post));
        return "details";
    }

    @GetMapping("/search")
    public String searchPost(@RequestParam(required = false, defaultValue = "") String text, Model model) {
        List<Post> posts;
        if (text != null && !text.isEmpty()) {
            posts = postService.findPostByText(text);
        } else {
            posts = postService.postList();
        }
        model.addAttribute("posts", posts);
        return "posts";
    }


}
