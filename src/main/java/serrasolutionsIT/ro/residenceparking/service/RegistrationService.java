package serrasolutionsIT.ro.residenceparking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import serrasolutionsIT.ro.residenceparking.repository.residents.Residents;
import serrasolutionsIT.ro.residenceparking.repository.residents.ResidentsRepo;
import serrasolutionsIT.ro.residenceparking.repository.residentscars.ResidentsCars;

import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final ResidentsRepo residentsRepo;
    private final Residents residents;
    private final ResidentsCars residentsCars;


    public void addLocatari(String firstName, String lastName, String username, String password, String block, String scale, String apartment, String registrationNumber){
        residents.setFirstName(firstName);
        residents.setLastName(lastName);
        residents.setUsername(username);
        residents.setPassword(password);
        residents.setBlock(block);
        residents.setScale(scale);
        residents.setApartment(apartment);
        residents.setDate(Calendar.getInstance().getTime());
        residentsCars.setRegistrationNumber(registrationNumber);
        residentsCars.setDate(Calendar.getInstance().getTime());
        residents.setResidentsCars(residentsCars);

        residentsRepo.save(residents);
    }

    public Iterable<Residents> getAll(){
        return residentsRepo.findAll();
    }

    public Iterable<Residents> takeResidentsByRegistrationNumber(){
        return residentsRepo.findAllByRegistrationNumber();
    }
}
