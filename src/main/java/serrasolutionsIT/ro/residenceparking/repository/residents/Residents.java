package serrasolutionsIT.ro.residenceparking.repository.residents;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import serrasolutionsIT.ro.residenceparking.repository.residentscars.ResidentsCars;
import serrasolutionsIT.ro.residenceparking.repository.securityaccount.SecurityAccount;


import java.security.Security;
import java.util.Date;


@Entity
@Table(name = "residents")
@Getter
@Setter
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
}
