package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions",institutionService.showAll());
        model.addAttribute("bags", donationService.totalBags());
        model.addAttribute("donations", donationService.totalDonations());
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model){
        return "register";
    }
}
