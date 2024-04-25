package serrasolutionsIT.ro.residenceparking.controller.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import serrasolutionsIT.ro.residenceparking.repository.residents.Residents;
import serrasolutionsIT.ro.residenceparking.service.RegistrationService;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }
    @GetMapping("register-action")
    public ModelAndView registration(@RequestParam("firstName") String firstName,
                                     @RequestParam("lastName") String lastName,
                                     @RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("block") String block,
                                     @RequestParam("scale") String scale,
                                     @RequestParam("apartment") String apartment,
                                     @RequestParam("registrationNumber") String registrationNumber) {
        registrationService.addLocatari(firstName, lastName, username, password,block,scale,apartment, registrationNumber);

        return new ModelAndView("redirect:index.html");
    }

    @GetMapping("/info")
    @ResponseBody
    public Iterable<Residents> takeInfo(){
        return registrationService.getAll();
    }
    @GetMapping("/resident")
    @ResponseBody
    public Iterable<Residents> takeResidentsByRegistrationNumber(){
        return registrationService.takeResidentsByRegistrationNumber();
    }
}
