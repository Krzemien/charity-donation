package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class DonationController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    public DonationController(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping("/form")
    public String formView(Model model){
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        model.addAttribute("categories", categoryService.showAll());
        model.addAttribute("institutions", institutionService.showAll());

        return "form";
    }

    @PostMapping("/form")
    public String formValid(@ModelAttribute("donation") @Valid Donation donation,
                            @AuthenticationPrincipal CurrentUser currentUser,
                            BindingResult result,
                            Model model
    ){
        model.addAttribute("categories", categoryService.showAll());
        model.addAttribute("institutions", institutionService.showAll());

        if (result.hasErrors()) {
            model.addAttribute("info","Formularz zawiera błędy, przejrzyj go jeszcze raz i popraw.");
            return "form";
        }

        donation.setUser(currentUser.getUser());
        donationService.saveDonation(donation);
        return "redirect:/";

    }

}
