package I4404.Project.AirlineCompanySystem.services;

import I4404.Project.AirlineCompanySystem.FlightObserver.FlightObserverContext;
import I4404.Project.AirlineCompanySystem.models.Ticket;
import I4404.Project.AirlineCompanySystem.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    TicketRepository TicketRepository ;
    FlightObserverContext FlightObserverContext ;

    public NotificationService(TicketRepository ticketRepository , FlightObserverContext FlightObserverContext) {
        TicketRepository = ticketRepository;
        this.FlightObserverContext=FlightObserverContext ;
    }

    public void notifyObservers (Long flightId , String message){
        List <Ticket> tickets = TicketRepository.findByflightId(flightId);
        FlightObserverContext.notifyObservers( message,tickets );
    }
}
