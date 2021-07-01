package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DonationController {

    @RequestMapping("/form")
    public String form(Model model){

        return "form";
    }
}
