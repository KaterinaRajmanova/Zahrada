package katerinarajmanova.projekty.zahrada.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public ModelAndView zkouska() {
        ModelAndView result = new ModelAndView("detail");
        return result;
    }


}
