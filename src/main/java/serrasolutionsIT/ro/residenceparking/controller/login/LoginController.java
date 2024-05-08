package serrasolutionsIT.ro.residenceparking.controller.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import serrasolutionsIT.ro.residenceparking.exceptions.UserException;
import serrasolutionsIT.ro.residenceparking.repository.residents.Residents;
import serrasolutionsIT.ro.residenceparking.security.UserSession;
import serrasolutionsIT.ro.residenceparking.service.SecurityAccountService;
import serrasolutionsIT.ro.residenceparking.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private ModelAndView modelAndView;
    private final SecurityAccountService securityAccountService;
    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView register(){
        return new ModelAndView("login");
    }

    @GetMapping("login-action")
    public ModelAndView loginAction(@RequestParam("username") String username,
                                     @RequestParam("password") String password) {
        try{
            securityAccountService.validateUserAccount(username,password);
            modelAndView = new ModelAndView("dashboard");
            List<Residents> residentsInformation = userService.returnUserInformation(username);
            modelAndView.addObject("userInformation", residentsInformation);

        }catch (UserException e){
            modelAndView.addObject("error", e.getMessage());
        }
        return modelAndView;
    }
}
