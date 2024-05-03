package serrasolutionsIT.ro.residenceparking.repository.residents;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidentsRepo extends CrudRepository<Residents, Integer> {

    @Query(value = "select residents.id, first_name, last_name, username, block, scale, apartment, registration_number, residents.date, residents_cars from residents inner join residents_cars on residents.id = residents_cars.id where registration_number = :registration_Number",
            nativeQuery = true)
    List<Residents> findAllByRegistrationNumber(@Param("registration_Number") String registrationNumber);

    @Query(value = "select * from residents where id = 1", nativeQuery = true)
    List<Residents> findUserAndPwd();

    @Query(value = "select first_name, last_name, username, block, scale, apartment, registration_number from residents_cars inner join residents on residents.residents_cars = residents_cars.id where username = :username", nativeQuery = true)
    List<Residents> findUserByUsername(@Param("username") String username);

}
