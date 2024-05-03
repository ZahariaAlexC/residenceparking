package serrasolutionsIT.ro.residenceparking.repository.securityaccount;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import serrasolutionsIT.ro.residenceparking.repository.residentscars.ResidentsCars;

import java.util.List;

@Repository
public interface SecurityAccountRepo extends CrudRepository<SecurityAccount, Integer> {

    @Query(value = "select id, username, password, date from security_account where username = :username", nativeQuery = true)
    List<SecurityAccount> checkUserAccount(@Param("username") String username);
}
