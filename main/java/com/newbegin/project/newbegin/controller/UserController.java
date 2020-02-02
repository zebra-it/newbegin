package com.newbegin.project.newbegin.controller;

import com.newbegin.project.newbegin.model.Post;
import com.newbegin.project.newbegin.model.Role;
import com.newbegin.project.newbegin.model.User;
import com.newbegin.project.newbegin.service.PostService;
import com.newbegin.project.newbegin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/user")
//@PreAuthorize("hasAuthority('ADMIN')") // проверка перед выполнение метода наличия прав у юзера
public class UserController {

    @Autowired
    private PostService postService;

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
        userService.saveUser(user, username, form);
        return "redirect:/user";
    }

    @GetMapping("profile/{user1}")
    public String getProfile(@AuthenticationPrincipal User user, @PathVariable User user1, Model model) {
        Set<Post> posts = user1.getPosts();

        model.addAttribute("posts", posts);
        model.addAttribute("isCurrentUser", user.equals(user1));
        return "profile";
    }

    @PostMapping("profile/update")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @RequestParam String password,
                                @RequestParam String email,
                                Model model) {
        boolean emptyPass = StringUtils.isEmpty(password);

        if (emptyPass) {
            model.addAttribute("passwordError", "Сначала измените пароль");
            return "update";
        } else {

            userService.updateProfile(user, password, email);
        }
        return "redirect:/user/profile/" + user.getId();
    }


    @GetMapping("profile/update")
    public String editProfile() {
        return "update";
    }

}
