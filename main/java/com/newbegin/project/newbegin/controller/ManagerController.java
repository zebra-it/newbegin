package com.newbegin.project.newbegin.controller;

import com.newbegin.project.newbegin.model.Post;
import com.newbegin.project.newbegin.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/statistics")
public class ManagerController {
    @Autowired
    private PostService postService;

    @GetMapping
    public String posts(Model model) {
        List<Post> posts = postService.orderByTime();

        model.addAttribute("posts", posts);
        return "statistics";
    }


}
