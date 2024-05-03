package serrasolutionsIT.ro.residenceparking.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import serrasolutionsIT.ro.residenceparking.security.UserSession;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    private final UserSession userSession;
    @GetMapping("/dashboard")
    public ModelAndView showDashboard(){
        ModelAndView modelAndView = new ModelAndView("index");
        if (userSession.getId()>0){
            modelAndView = new ModelAndView("dashboard");
            return modelAndView;
        } else {
            return modelAndView;
        }
    }
}
