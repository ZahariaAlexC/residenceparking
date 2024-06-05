package serrasolutionsIT.ro.residenceparking.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import serrasolutionsIT.ro.residenceparking.repository.residents.Residents;
import serrasolutionsIT.ro.residenceparking.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    private final UserService userService;


    @GetMapping("update-information")
    public ModelAndView loginAction(@RequestParam("username") String username,
                                    @RequestParam("registerPlate") String password) {
        ModelAndView modelAndView = new ModelAndView("dashboard.html");
        List<Residents> residentsInformation = userService.returnUserInformation(username);
        modelAndView.addObject("userInformation", residentsInformation);
        return modelAndView;
    }
}
