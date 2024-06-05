package serrasolutionsIT.ro.residenceparking.controller.mainpage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ResidenceParkingController {
    @GetMapping("/residenceParking")
    public ModelAndView mainPage(){
        return new ModelAndView("residenceParking");
    }
}
