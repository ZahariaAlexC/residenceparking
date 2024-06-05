package serrasolutionsIT.ro.residenceparking.repository.securityaccount;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import serrasolutionsIT.ro.residenceparking.repository.residentscars.ResidentsCars;

import java.util.List;

@Repository
public interface SecurityAccountRepo extends CrudRepository<SecurityAccount, Integer> {

    @Query(value = "select security_account.id, security_account.username, password, security_account.date from security_account where username = :username", nativeQuery = true)
    List<SecurityAccount> checkUserAccount(@Param("username") String username);
    @Modifying
    @Query(value = "Update security_account set username = :username, password = :password where id = :id", nativeQuery = true)
    void updateUserAccountSecurity(@Param("username") String username,
                                   @Param("password") String password,
                                   @Param("id") String id);
}
