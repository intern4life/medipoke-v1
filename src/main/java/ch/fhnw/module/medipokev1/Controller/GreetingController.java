package ch.fhnw.module.medipokev1.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping(value="/login")
    public String getLoginRole(Authentication auth) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String role = userDetails.getAuthorities().toArray()[1].toString();
        return role;
    }

}
