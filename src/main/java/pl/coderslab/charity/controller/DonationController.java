package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.ArrayList;
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

//    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @GetMapping("/form")
    public String formView(Model model){
        System.out.println("qwe");
        Donation donation = new Donation();
        model.addAttribute("donation", donation);
        model.addAttribute("categories", categoryService.showAll());
        model.addAttribute("institutions", institutionService.showAll());
        return "form";
    }
//    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @PostMapping("/form")
    public String formValid(@ModelAttribute("donation") @Valid Donation donation, BindingResult result, Model model){
        model.addAttribute("categories", categoryService.showAll());
        model.addAttribute("institutions", institutionService.showAll());
        if (result.hasErrors()) {
            model.addAttribute("info","Formularz zawiera błędy, przejrzyj go jeszcze raz i popraw.");
            return "form";
        }

        donationService.saveDonation(donation);
        return "redirect:/";

    }
}
