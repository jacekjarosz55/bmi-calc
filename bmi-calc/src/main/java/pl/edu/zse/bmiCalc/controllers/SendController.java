package pl.edu.zse.bmiCalc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.Validate;
import pl.edu.zse.bmiCalc.exceptions.ValidationException;
import pl.edu.zse.bmiCalc.model.Bmi;
import pl.edu.zse.bmiCalc.services.IBmiService;
import pl.edu.zse.bmiCalc.validators.BmiValidator;

@Controller
public class SendController {

    @Autowired
    IBmiService bmiService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendMenu() {
        return "send";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String send(Model model, @RequestParam int wzrost, @RequestParam int waga) {
        try{
            BmiValidator.validateWaga(waga);
            BmiValidator.validateWzrost(wzrost);
        }
        catch (ValidationException e){
            model.addAttribute("problem", e.getValidationInfo());
            return "send";
        }

        Bmi bmi = new Bmi();
        bmi.setWzrost(wzrost);
        bmi.setWaga(waga);
        bmiService.addBmi(bmi);


        if(bmiService.getBmiById(bmi.getId()).isPresent()){
            model.addAttribute("resultid", bmi.getId());
        }
        else{
            model.addAttribute("problem","Unknown error");
        }
        return "send";
    }
}