package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

@Controller()
@RequestMapping("/admin")
public class AdminController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserService userService;

    public AdminController(InstitutionService institutionService, DonationService donationService, UserService userService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
    }

    @GetMapping("/institutions")
    public String institutionsView(){
        return "institutions";
    }

    @GetMapping("/donations")
    public String donationsView(){
        return "donations";
    }

    @GetMapping("/users")
    public String usersView(){
        return "users";
    }

    @GetMapping("/admins")
    public String adminsView(){
        return "admins";
    }

}
