package serrasolutionsIT.ro.residenceparking.repository.residents;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidentsRepo extends CrudRepository<Residents, Integer> {

    @Query(value = "select residents.id, first_name, last_name, password, username, block, apartment,scale,residents.date,registration_number,residents_cars from residents inner join residents_cars on residents.id = residents_cars.id where registration_number = 'B25ZAL'",
            nativeQuery = true)
    List<Residents> findAllByRegistrationNumber();

}
