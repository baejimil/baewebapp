package com.baejimeel.springboot.baewebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping("/")
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", "baejimeel");
        return "welcome";
    }

}
