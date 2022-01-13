package pl.edu.zse.bmiCalc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.zse.bmiCalc.model.Bmi;
import pl.edu.zse.bmiCalc.services.IBmiService;

import java.util.Optional;


@Controller
public class ReadController {
    @Autowired
    IBmiService bmiService;

    @RequestMapping(value="/read", method = RequestMethod.GET)
    public String readmenu()
    {
        return "read";
    }
   @RequestMapping(value="/read", method = RequestMethod.POST)
   public String read(Model model, @RequestParam int id)
   {
       Optional<Bmi> bmiBox  = bmiService.getBmiById(id);
       if(bmiBox.isPresent())
       {
           Bmi bmi = bmiBox.get();
           model.addAttribute("bmi",bmi);
           model.addAttribute("obliczonebmi",bmiService.calculateBmi(bmi));
       }
       else model.addAttribute("problem",true);
       return "read";
   }
}
