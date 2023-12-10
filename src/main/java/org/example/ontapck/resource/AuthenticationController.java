package org.example.ontapck.resource;

import lombok.AllArgsConstructor;
import org.example.ontapck.models.User;
import org.example.ontapck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user) {
        System.out.println(user);
        userService.register(user);
        return "redirect:/login";
    }
}
