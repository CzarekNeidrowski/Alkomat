package com.akademiakodu.Alcomat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("result","");

        return "home";
    }



    @RequestMapping (method = RequestMethod.POST)
    public String getResult( ModelMap modelMap, @RequestParam Integer weight, @RequestParam Integer quantity, @RequestParam String sex, @RequestParam String drinkName){
        DecimalFormat df = new DecimalFormat("#.##");
        AlkoholCalculator alc = new AlkoholCalculator("",0);
        if (weight==null) return "home";
        if (quantity==null) return "home";
        if (sex==null) return "home";
        if (drinkName==null) return  "home";
        if (drinkName.equals("Piwo")) {
            alc = new AlkoholCalculator("Piwo",0.05f);

        }else if (drinkName.equals("Wodka")) alc = new AlkoholCalculator("Wodka",0.40f);
        else if (drinkName.equals("Wino")) alc = new AlkoholCalculator("Wino",0.14f);
        else if (drinkName.equals("Bimber")) alc = new AlkoholCalculator("Bimber",0.70f);
        boolean male;

        if(sex.equals("K")) male = false;
        else male = true;

        float r = alc.calculatePerMil(quantity,weight,male);
        modelMap.addAttribute("result",df.format(r)+"‰");
       // modelMap.addAttribute("result",drinkName+" "+sex+" "+Float.toString(quantity));
        return "home";

    }
}