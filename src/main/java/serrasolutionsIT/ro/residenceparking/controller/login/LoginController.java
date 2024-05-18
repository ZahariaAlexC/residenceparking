package serrasolutionsIT.ro.residenceparking.controller.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import serrasolutionsIT.ro.residenceparking.exceptions.UserException;
import serrasolutionsIT.ro.residenceparking.repository.residents.Residents;
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
    public ModelAndView login(){
        return new ModelAndView("login");
    }
    @GetMapping("/changePassword")
    public ModelAndView changePassword(){
        return new ModelAndView("changePassword");
    }

    @GetMapping("changePassword-action")
    public ModelAndView changePassword(@RequestParam("oldpassword") String oldPassword,
                                       @RequestParam("newpassword") String newPassword,
                                       @RequestParam("confirmpassword") String confirmPassword){
        if(securityAccountService.userValidation(userService.getUsername()).getUsername().equals(userService.getUsername()) &&
                securityAccountService.userValidation(userService.getUsername()).getPassword().equals(oldPassword) &&
                newPassword.equals(confirmPassword)){
            securityAccountService.updateUserAccountSecurity(userService.getUsername(), newPassword, userService.getId());
        }
        modelAndView = new ModelAndView("dashboard");
        return modelAndView;
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
