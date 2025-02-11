package I4404.Project.AirlineCompanySystem.repositories;

import I4404.Project.AirlineCompanySystem.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOriginAndDestinationAndDepartureDate(String Origin , String Destination , String Date);

}
