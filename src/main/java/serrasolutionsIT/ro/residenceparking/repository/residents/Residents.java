package serrasolutionsIT.ro.residenceparking.repository.residents;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import serrasolutionsIT.ro.residenceparking.repository.residentscars.ResidentsCars;
import serrasolutionsIT.ro.residenceparking.repository.securityaccount.SecurityAccount;


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
    private String block;
    private String scale;
    private String apartment;
    private Date date;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "residentsCars", referencedColumnName = "id")
    private ResidentsCars residentsCars;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "securityAccount", referencedColumnName = "id")
    private SecurityAccount securityAccount;
}
