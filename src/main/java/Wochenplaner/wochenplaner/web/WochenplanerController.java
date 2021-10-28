package Wochenplaner.wochenplaner.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class WochenplanerController {
    @GetMapping(path = "/")
    public ModelAndView showStartseite(){
        return new ModelAndView("Hauptseite");

    }


}
