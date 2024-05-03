package serrasolutionsIT.ro.residenceparking.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import serrasolutionsIT.ro.residenceparking.exceptions.UserException;
import serrasolutionsIT.ro.residenceparking.repository.securityaccount.SecurityAccount;
import serrasolutionsIT.ro.residenceparking.repository.securityaccount.SecurityAccountRepo;

import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class SecurityAccountService {

    @Autowired
    private final SecurityAccountRepo securityAccountRepo;

    @Transactional
    public void addUserAndPwd(String username, String pwd){
        SecurityAccount securityAccount = new SecurityAccount();
        securityAccount.setUsername(username);
        securityAccount.setPassword(pwd);
        securityAccount.setDate(Calendar.getInstance().getTime());

        securityAccountRepo.save(securityAccount);
    }


    public void validateUserAccount(String username, String password) throws UserException {
        boolean userFound = false;
        for(SecurityAccount user : securityAccountRepo.checkUserAccount(username)){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                userFound = true;
                break;
            }
        }
        if (!userFound) {
            throw new UserException("EMAIL/PAROLA INCORECTE");
        }
    }
}