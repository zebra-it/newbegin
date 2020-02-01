package com.newbegin.project.newbegin.controller;

import com.newbegin.project.newbegin.model.User;
import com.newbegin.project.newbegin.repository.UserReposiroty;
import com.newbegin.project.newbegin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserReposiroty userReposiroty;

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String registration() {

        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = ControllerUtil.getErrors(result);
            model.mergeAttributes(errorMap);
            model.addAttribute("post", "hm");
        }

        User userFromDb = userReposiroty.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.addAttribute("post", "User exists!");
            return "reg";
        }
        userService.addUser(user);
        return "redirect:/login";
    }
}
