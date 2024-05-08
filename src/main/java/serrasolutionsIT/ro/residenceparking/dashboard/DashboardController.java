package serrasolutionsIT.ro.residenceparking.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import serrasolutionsIT.ro.residenceparking.exceptions.UserException;
import serrasolutionsIT.ro.residenceparking.repository.residents.Residents;
import serrasolutionsIT.ro.residenceparking.security.UserSession;
import serrasolutionsIT.ro.residenceparking.service.RegistrationService;
import serrasolutionsIT.ro.residenceparking.service.SecurityAccountService;
import serrasolutionsIT.ro.residenceparking.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    private final SecurityAccountService securityAccountService;
    private final UserService userService;


    @GetMapping("update-information")
    public ModelAndView loginAction(@RequestParam("username") String username,
                                    @RequestParam("registerPlate") String password) {
        ModelAndView modelAndView = new ModelAndView("appInterface.html");
        return modelAndView;
    }
}
