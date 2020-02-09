package com.newbegin.project.newbegin.controller;

import com.newbegin.project.newbegin.repository.PostRepository;
import com.newbegin.project.newbegin.service.ManagementService;
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
    private ManagementService managementService;

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String posts() {
        return "statistics";
    }

    @GetMapping("/postStatistics")
    public String getPosts(Model model){
        List<Integer> countPostsDate = postRepository.countPostsByDate();
        List<Integer> countPostsTime = postRepository.countPostsByTime();
        List<String> datePosts = postRepository.datePosts();
        List<String> timePosts = postRepository.getTime();
        model.addAttribute("datePosts", datePosts);
        model.addAttribute("countPostsDate",countPostsDate);
        model.addAttribute("countPostsTime",countPostsTime);
        model.addAttribute("timePosts",timePosts);
        return "postStatistics";
    }



}
