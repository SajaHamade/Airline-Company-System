package I4404.Project.AirlineCompanySystem.controllers;


import I4404.Project.AirlineCompanySystem.models.Flight;
import I4404.Project.AirlineCompanySystem.models.Ticket;
import I4404.Project.AirlineCompanySystem.services.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
@RestController
@RequestMapping("/flights")
public class FlightCotroller {
    FlightService FlightService ;

    public FlightCotroller(FlightService flightService) {
        FlightService = flightService;
    }

    @GetMapping("/")
    public List <Flight> getAllFlights(){
        return FlightService.getAllFlights() ;

    }


    @GetMapping("/{id}")
    public Flight getFlightOfId(@PathVariable Long id){
        return FlightService.getFlightById(id) ;

    }




    @PostMapping("/add")
    public Flight addFlight(@RequestBody Flight flight) {

        return FlightService.addFlight(flight);
    }

    @PutMapping("/update/{id}")
    public Flight updateFlight(@RequestBody Flight flight, @PathVariable Long id) {
      return FlightService.updateFlight(id, flight);
    }

    @PostMapping("/book/{PassengerId}/{flightId}")
    public Ticket BookAFlight(
            @RequestParam String TypeOfSeat,
            @RequestParam String MealPreferences,
            @PathVariable Long PassengerId,
            @PathVariable Long flightId ) {

        try {

            return FlightService.BookFlight(PassengerId, flightId, TypeOfSeat, MealPreferences);
        } catch (Exception e) {
            e.printStackTrace();  // This prints the actual error
            throw new RuntimeException("Booking failed: " + e.getMessage());
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id) {
        FlightService.deleteFlight(id); // Call the service to delete the flight
        return ResponseEntity.ok("Flight with ID " + id + " has been deleted successfully");
    }


    @PostMapping("/search/{Origin}/{Destination}/{Date}")
    public List<Flight> SearchForAFlight (@PathVariable String Origin , @PathVariable String Destination , @PathVariable String Date ){

        return FlightService.SearchForFlights(Origin , Destination , Date) ;
    }

}
