package I4404.Project.AirlineCompanySystem.repositories;

import I4404.Project.AirlineCompanySystem.FlightObserver.FlightObserverContext;
import I4404.Project.AirlineCompanySystem.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List <Ticket> findByflightId(Long id);
    void deleteByFlightId(Long flightId);

}
