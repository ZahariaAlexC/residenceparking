package serrasolutionsIT.ro.residenceparking.service;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serrasolutionsIT.ro.residenceparking.repository.residents.Residents;
import serrasolutionsIT.ro.residenceparking.repository.residents.ResidentsRepo;

import java.util.List;

@Service
public class UserService {
    @Autowired
    ResidentsRepo residentsRepo;

    @Getter
    private String username;
    @Getter
    private int id;

    public List<Residents> returnUserInformation(String username){
        this.username = residentsRepo.findUserByUsername(username).get(0).getUsername();
        id = residentsRepo.findUserByUsername(username).get(0).getId();
        return residentsRepo.findUserByUsername(username);
    }

}
