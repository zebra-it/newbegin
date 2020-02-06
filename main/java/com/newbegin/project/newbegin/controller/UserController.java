package com.newbegin.project.newbegin.controller;

import com.newbegin.project.newbegin.model.Role;
import com.newbegin.project.newbegin.model.User;
import com.newbegin.project.newbegin.service.PostService;
import com.newbegin.project.newbegin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PostService postService;
    @Value("${upload.path}")
    private String path;
    @Autowired
    private UserService userService;

    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {

        model.addAttribute("roles", Role.values());
        model.addAttribute("user", user);

        return "userEdit";
    }

    // @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(@RequestParam String username,
                           @RequestParam Map<String, String> form,
                           @RequestParam("userId") User user) {
        userService.saveUserByAdmin(user, username, form);
        return "redirect:/user";
    }


    @GetMapping("subscribe/{user}")
    public String subscribe(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user
    ) {
        userService.follow(currentUser, user);

        return "redirect:/posts/user-posts/" + user.getId();
    }

    @GetMapping("unsubscribe/{user}")
    public String unsubscribe(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user
    ) {
        userService.unfollow(currentUser, user);

        return "redirect:/posts/user-posts/" + user.getId();
    }

    @GetMapping("{type}/{user}/list")
    public String userList(
            Model model,
            @PathVariable User user,
            @PathVariable String type
    ) {
        model.addAttribute("userChannel", user);
        model.addAttribute("type", type);

        if ("following".equals(type)) {
            model.addAttribute("users", user.getFollowing());
        } else {
            model.addAttribute("users", user.getFollowers());
        }

        return "follow";
    }

    @PostMapping("profile/update")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @RequestParam String password,
                                @RequestParam String email,
                                Model model) {


        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{6,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        boolean emptyPass = StringUtils.isEmpty(password);

        if (emptyPass) {
            model.addAttribute("passwordError", "Сначала измените пароль");
            return "update";
        }

        if (!matcher.matches()) {
            model.addAttribute("passwordError", "Пароль должен быть от 6 символов" +
                    ", содержать верхний и нижний регистр, цифры и символы");
            return "update";
        } else if (matcher.matches()) {

            userService.updateProfile(user, password, email);
            model.addAttribute("message", "Профиль изменен");
        }


        return "update";
    }


    @GetMapping("profile/update")
    public String editProfile() {
        return "update";
    }


}
