package serrasolutionsIT.ro.residenceparking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serrasolutionsIT.ro.residenceparking.repository.residents.Residents;
import serrasolutionsIT.ro.residenceparking.repository.residents.ResidentsRepo;

import java.util.List;

@Service
public class UserService {

    @Autowired
    ResidentsRepo residentsRepo;


    public List<Residents> returnUserInformation(String username){
        return residentsRepo.findUserByUsername(username);
    }
}
