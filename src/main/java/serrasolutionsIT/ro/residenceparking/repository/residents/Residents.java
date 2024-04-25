package serrasolutionsIT.ro.residenceparking.repository.residents;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import serrasolutionsIT.ro.residenceparking.repository.residentscars.ResidentsCars;


import java.util.Date;


@Entity
@Table(name = "residents")
@Getter
@Setter
@Component
public class Residents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String block;
    private String scale;
    private String apartment;
    private Date date;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "residentsCars", referencedColumnName = "id")
    private ResidentsCars residentsCars;


}
