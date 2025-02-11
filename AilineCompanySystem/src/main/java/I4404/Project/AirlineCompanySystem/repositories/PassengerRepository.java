package I4404.Project.AirlineCompanySystem.repositories;

import I4404.Project.AirlineCompanySystem.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger , Long> {

    Passenger findByUsername(String username);
    Passenger findByUsernameAndPassword(String username , String password);
}
