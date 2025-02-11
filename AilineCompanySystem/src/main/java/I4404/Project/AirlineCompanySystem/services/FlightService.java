package I4404.Project.AirlineCompanySystem.services;

import I4404.Project.AirlineCompanySystem.models.Flight;
import I4404.Project.AirlineCompanySystem.models.Passenger;
import I4404.Project.AirlineCompanySystem.models.Ticket;
import I4404.Project.AirlineCompanySystem.repositories.FlightRepository;
import I4404.Project.AirlineCompanySystem.repositories.PassengerRepository;
import I4404.Project.AirlineCompanySystem.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    FlightRepository FlightRepository;
    PassengerRepository PassengerRepository ;
    MealService MealService ;
    PricingService PricingService ;
    TicketRepository TicketRepository ;
    SeatService SeatService ;
    NotificationService NotificationService ;

    @Autowired
    public FlightService(FlightRepository flightRepository , PassengerRepository PassengerRepository ,NotificationService NotificationService , MealService MealService , PricingService PricingService , TicketRepository TicketRepository , SeatService SeatService) {
        FlightRepository = flightRepository;
        this.PassengerRepository = PassengerRepository ;
        this.MealService = MealService ;
        this.PricingService = PricingService ;
        this.TicketRepository = TicketRepository ;
        this.SeatService = SeatService ;
        this.NotificationService = NotificationService ;

    }

    public List <Flight> getAllFlights(){
        return FlightRepository.findAll() ;
    }

    public Flight getFlightById(Long id){
        return FlightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + id));
    }

    public Flight addFlight(Flight flight) {
        return FlightRepository.save(flight);
    }

    public Flight updateFlight(Long flightId, Flight updatedFlight) {
        return FlightRepository.findById(flightId)
                .map(flight -> {
                    flight.setOrigin(updatedFlight.getOrigin());
                    flight.setDestination(updatedFlight.getDestination());
                    flight.setDepartureDate(updatedFlight.getDepartureDate());
                    flight.setDepartureTime(updatedFlight.getDepartureTime());
                    flight.setTimeInterval(updatedFlight.getTimeInterval());
                    flight.setAircraft(updatedFlight.getAircraft());
                    flight.setBasePrice(updatedFlight.getBasePrice());
                    flight.setEconomySeats(updatedFlight.getEconomySeats());
                    flight.setBusinessSeats(updatedFlight.getBusinessSeats());
                    NotificationService.notifyObservers(flightId , "The Flight going from" +updatedFlight.getOrigin()+"to"+updatedFlight.getDestination()+" was Updated , Please Check your Flight for details");
                    return FlightRepository.save(flight);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found"));
    }

    public Ticket BookFlight (Long PassengerId , Long flightId , String TypeOfSeat , String MealPreference){


        Flight bookedFlight = FlightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + flightId));

        Passenger Passenger = PassengerRepository.findById(PassengerId)
                .orElseThrow(() -> new RuntimeException("Passenger not found with ID: " + PassengerId));

        SeatService.ManageSeats(bookedFlight , TypeOfSeat);

        Long Price = PricingService.calculateTicketPrice(TypeOfSeat , bookedFlight);
        String MealType = MealService.getMealForPassenger(MealPreference);

        Ticket ticket = new Ticket();
        ticket.setFlightId(flightId);
        ticket.setPassengerId(PassengerId);
        ticket.setSeatType(TypeOfSeat);
        ticket.setMealType(MealType);
        ticket.setPrice(Price);

        FlightRepository.save(bookedFlight); //Save the flight wih its new updated Number of Seats


        return TicketRepository.save(ticket);

    }

@Transactional
    public void deleteFlight(Long flightId) {
        Flight flight = FlightRepository.findById(flightId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found"));
    NotificationService.notifyObservers(flightId , "The Flight going from "+flight.getOrigin()+"to"+flight.getDestination()+" was Deleted ,Please check your email for Refunds Details");
    TicketRepository.deleteByFlightId(flightId);
        FlightRepository.deleteById(flightId);

    }

    public List<Flight> SearchForFlights(String origin, String destination, String date) {

        List<Flight> flights = FlightRepository.findByOriginAndDestinationAndDepartureDate(origin, destination, date);

        if (flights.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No flights found for the given criteria.");
        }

        return flights;
    }

}

