package I4404.Project.AirlineCompanySystem.FlightObserver;

import I4404.Project.AirlineCompanySystem.models.Ticket;

import java.util.List;

public interface FlightObserver {
    void notifyObservers(String message , List<Ticket> Tickets);
}
