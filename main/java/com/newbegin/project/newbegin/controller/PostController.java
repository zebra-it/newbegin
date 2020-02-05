package com.newbegin.project.newbegin.controller;

import com.newbegin.project.newbegin.model.Post;
import com.newbegin.project.newbegin.model.Tag;
import com.newbegin.project.newbegin.model.User;
import com.newbegin.project.newbegin.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Value("${upload.path}")
    private String path;

    @GetMapping
    public String showPost(Model model) {
        Iterable<Post> posts = postService.showAll();

        model.addAttribute("posts", posts);
        return "posts";
    }


    @PostMapping("/newpost")
    public String addPost(@AuthenticationPrincipal User user,
                          @Valid Post post,
                          BindingResult result, Model model,
                          @RequestParam("file") MultipartFile file) throws IOException {

        if (file != null) {
            File uploadDir = new File(path);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultName =     uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(path + File.separator + resultName));
            post.setFilename(resultName);
        }
        if (result.hasErrors()) {
            Map<String, String> errorMap = ControllerUtil.getErrors(result);

            model.mergeAttributes(errorMap);

        } else {
            postService.addNewPost(post, user, model);
        }

        Iterable<Post> posts = postService.showAll();
        model.addAttribute("posts", posts);
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

    @GetMapping("/search/{tag}")
    public String searchByTag(@PathVariable String tag, Model model) {
        List<Tag> inTags = postService.findInTags(tag);
        model.addAttribute("posts", inTags);
        return "posts";
    }
    @GetMapping("/user-posts/{user}")
    public String userPosts(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Post post
    ) {

        Set<Post> posts = user.getPosts();

        model.addAttribute("userChannel", user);
        model.addAttribute("subscriptionsCount", user.getFollowing().size());
        model.addAttribute("subscribersCount", user.getFollowers().size());
        model.addAttribute("isSubscriber", user.getFollowers().contains(currentUser));
        model.addAttribute("posts", posts);
        model.addAttribute("post", post);

        model.addAttribute("isCurrentUser", currentUser.equals(user));


        return "userPosts";
    }


}
