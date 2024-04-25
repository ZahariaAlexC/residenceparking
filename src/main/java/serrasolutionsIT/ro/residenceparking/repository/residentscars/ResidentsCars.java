package serrasolutionsIT.ro.residenceparking.repository.residentscars;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "residentsCars")
@Component
public class ResidentsCars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String modelCar;
    private String registrationNumber;
    private Date date;

}
