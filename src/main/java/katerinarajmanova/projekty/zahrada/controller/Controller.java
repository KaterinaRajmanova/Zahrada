package katerinarajmanova.projekty.zahrada.controller;

import katerinarajmanova.projekty.zahrada.entity.Prace;
import katerinarajmanova.projekty.zahrada.entity.Rostlina;
import katerinarajmanova.projekty.zahrada.service.TridaService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    private final TridaService service;


    public Controller(TridaService service) {
        this.service = service;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView result = new ModelAndView("seznam");
        Iterable<Rostlina> seznamRostlin = service.seznam();
        result.addObject("seznam", seznamRostlin);
        return result;
    }

    @GetMapping("/jaro")
    public ModelAndView jaro(@PageableDefault() Pageable pageable) {
        ModelAndView result = new ModelAndView("obdobi");
        Iterable<Rostlina> seznamRostlin = service.seznamJaro(pageable);
        result.addObject("seznam", seznamRostlin);
        result.addObject("obdobi","Jarní péče");
        return result;
    }

    @GetMapping("/podzim")
    public ModelAndView podzim(@PageableDefault() Pageable pageable) {
        ModelAndView result = new ModelAndView("obdobi");
        Iterable<Rostlina> seznamRostlin = service.seznamPodzim(pageable);
        result.addObject("seznam", seznamRostlin);
        result.addObject("obdobi","Podzimní péče");
        return result;
    }

    @GetMapping("/{id:[0-9]+}")
    public Object detail(@PathVariable Integer id, Pageable pageable) {
            ModelAndView result = new ModelAndView("detail");
            result.addObject("detail", service.findById(id,pageable));
            return result;
    }

    @GetMapping("/formular")
    public ModelAndView nova() {
        ModelAndView result = new ModelAndView("formular");
        result.addObject("form", new RostlinaForm());
        return result;
    }

    @PostMapping("/formular")
    public Object form(@ModelAttribute("form") @Valid RostlinaForm form, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "/formular";
//        }

//        String prace = "";
//        switch (form.getZvolenePrace().toString()) {
//            case Prace.OSTŘÍHAT:
//                prace = "ostrihat";
//                break;
//            case Prace.POHNOJIT:
//                prace = "pohnojit";
//                break;
//            case Prace.ODPLEVELIT:
//                prace = "odplevelit";
//                break;
//            case Prace.ROZSADIT:
//                prace = "rozsadit";
//                break;
//            default:
//                prace = "chyba";
//        }

        String praceJaro = "";
        for (Prace prace: form.getZvolenePraceJaro()) {
            praceJaro = praceJaro + prace.toString() + " ";
        }
        String pracePodzim = "";
        for (Prace prace: form.getZvolenePracePodzim()) {
            pracePodzim = pracePodzim + prace.toString() + " ";
        }

        Rostlina novaRostlina = new Rostlina(
                form.getLatinskyNazev(),
                form.getCeskyNazev(),
                form.getPopis(),
                praceJaro,
                pracePodzim,
                form.getDatumVysadby()
        );

        service.novaRostlina(novaRostlina);


        return new ModelAndView("/formular");

    }
}
