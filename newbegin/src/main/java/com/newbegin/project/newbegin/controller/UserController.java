package com.newbegin.project.newbegin.controller;

import com.newbegin.project.newbegin.model.Role;
import com.newbegin.project.newbegin.model.User;
import com.newbegin.project.newbegin.repository.UserReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
//@PreAuthorize("hasAuthority('ADMIN')") // проверка перед выполнение метода наличия прав у юзера
public class UserController {

    @Autowired
    private UserReposiroty userReposiroty;

    @GetMapping
    public String userList(Model model) {
        Iterable<User> users = userReposiroty.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("roles", Role.values());
        model.addAttribute("user", user);
        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam String username,
                           @RequestParam Map<String, String> form,
                           @RequestParam("userId") User user) {
        user.setUsername(username);
        Set<String> role = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (role.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userReposiroty.save(user);

        return "redirect:/user";
    }

}
