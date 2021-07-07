package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

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
    public String institutionsView(Model model){
        model.addAttribute("institutions", institutionService.showAll());

        return "institutions";
    }

    @GetMapping("/institution/edit/{id}")
    public String institutionEditView(@PathVariable Long id, Model model){
        Optional<Institution> institution = institutionService.show(id);
        model.addAttribute("institution", institution);

        return "institution-edit";
    }

//    @PostMapping("/institution/edit/{id}")
//    public String institutionEditValid(@PathVariable Long id, Model model){
//        Optional<Institution> institution = institutionService.show(id);
//        model.addAttribute("institution", institution);
//
//        return "institution-edit";
//    }

    @PostMapping("/institution/edit/{id}")
    public String institutionEditValid(@ModelAttribute("institution") @Valid Institution institution,
                                       @PathVariable Long id,
                                       BindingResult result,
                                       Model model
    ){
//        Optional<Institution> institutionTest = institutionService.show(id);
//        model.addAttribute("institution", institutionTest);

        model.addAttribute("institution", institution);

        if (result.hasErrors()) {
            return "institution-add";
        }

        institutionService.saveInstitution(institution);
        return "redirect:/admin/institutions";

    }

    @GetMapping("/institution/add")
    public String institutionAddView(Model model){
        Institution institution = new Institution();
        model.addAttribute("institution", institution);

        return "institution-add";
    }

    @PostMapping("/institution/add")
    public String institutionAddValid(@ModelAttribute("institution") @Valid Institution institution,
                                      BindingResult result,
                                      Model model
    ){

        if (result.hasErrors()) {
            return "institution-add";
        }

        institutionService.saveInstitution(institution);
        return "redirect:/admin/institutions";

    }

    @GetMapping("/donations")
    public String donationsView(Model model){
        model.addAttribute("donations", donationService.showAll());

        return "donations";
    }

    @GetMapping("/users")
    public String usersView(Model model){
        model.addAttribute("users", userService.findAll());

        return "users";
    }

    @GetMapping("/admins")
    public String adminsView(Model model){
//        model.addAttribute("admins", userService.findAdmins());

        return "admins";
    }

}
