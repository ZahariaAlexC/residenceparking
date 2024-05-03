package serrasolutionsIT.ro.residenceparking.repository.securityaccount;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import serrasolutionsIT.ro.residenceparking.repository.residentscars.ResidentsCars;

@Repository
public interface SecurityAccountRepo extends CrudRepository<SecurityAccount, Integer> {
}
