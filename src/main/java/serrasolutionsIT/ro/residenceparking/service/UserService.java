package serrasolutionsIT.ro.residenceparking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serrasolutionsIT.ro.residenceparking.repository.residents.ResidentsRepo;

@Service
public class UserService {

    @Autowired
    ResidentsRepo residentsRepo;
}
