package pl.edu.zse.bmiCalc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String mainRedirect() {
        return "redirect:/main";
    }

    @RequestMapping(value="/main", method= RequestMethod.GET)
    public String main() {
        return "main";
    }
}
