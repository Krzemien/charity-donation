package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final DonationService donationService;
    private final Validator validator;

    public UserController(UserService userService, DonationService donationService, Validator validator) {
        this.userService = userService;
        this.donationService = donationService;
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

    @GetMapping("/user")
    public String userFrom(@AuthenticationPrincipal CurrentUser currentUser,
                           Model model) {
        model.addAttribute("user", currentUser.getUser());

        return "user";
    }

    @PostMapping("/user")
    public String userValid(
            @ModelAttribute("user") @Valid User user,
                            @AuthenticationPrincipal CurrentUser currentUser,
                            BindingResult result
    ){
        if (result.hasErrors()) {
            return "user";
        }

        User updatedUser = currentUser.getUser();
        updatedUser.setUsername(user.getUsername());

        userService.editUser(updatedUser);

        return "redirect:/login";
    }

    @GetMapping("/list")
    public String listView(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        List<Donation> donations = donationService.showAllByUser(currentUser.getUser());
        model.addAttribute("donations", donations);
        return "list";
    }

    @GetMapping("/password")
    public String passwordView(@AuthenticationPrincipal CurrentUser currentUser,
                               Model model){
        model.addAttribute("user", currentUser.getUser());

        return "password";
    }

    @PostMapping ("/password")
    public String passwordValif(
            @ModelAttribute("user") @Valid User user,
            @AuthenticationPrincipal CurrentUser currentUser,
            BindingResult result
    ){
        if (result.hasErrors()) {
            return "password";
        }

        User updatedUser = currentUser.getUser();
        updatedUser.setPassword(user.getPassword());

        userService.changePassword(updatedUser);

        return "redirect:/login";
    }

}
