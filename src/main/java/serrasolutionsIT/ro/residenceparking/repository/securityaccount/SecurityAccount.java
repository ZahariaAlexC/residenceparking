package serrasolutionsIT.ro.residenceparking.repository.securityaccount;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "securityAccount")
@Component
public class SecurityAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private Date date;
}
