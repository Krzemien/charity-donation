package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
public class UserController {
    private final UserService userService;
    private final Validator validator;

    public UserController(UserService userService, Validator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @GetMapping("/login")
    public String loginForm(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, Model model) {
        model.addAttribute("user", new User());
        if (error != null){
            model.addAttribute("error", "Złe dane!");
        }

        if (logout != null){
            model.addAttribute("logout", "Wylogowano!");
        }

        return "login";
    }

    @GetMapping("/register")
    public String registerFrom(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "register";
        }

        userService.saveUser(user);

        return "redirect:/login";
    }
}
