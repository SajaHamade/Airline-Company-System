package I4404.Project.AirlineCompanySystem.services;

import I4404.Project.AirlineCompanySystem.models.Passenger;
import I4404.Project.AirlineCompanySystem.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RegistrationService {
    
    private PassengerRepository PassengerRepository ;

    
    @Autowired
    public RegistrationService(PassengerRepository PassengerRepository) {
    this.PassengerRepository = PassengerRepository ;
    }
    
    public Passenger RegisterPassenger(Passenger newPassenger){
        Passenger existingPassenger = PassengerRepository.findByUsername(newPassenger.getUsername());
        if (existingPassenger != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Username already exists. Please try again.");
        }

        Passenger Passenger = new Passenger();
        Passenger.setUsername(newPassenger.getUsername());
        Passenger.setName(newPassenger.getName());
        Passenger.setPassword(newPassenger.getPassword());
        Passenger.setEmail(newPassenger.getEmail());
        Passenger.setCardNumber(newPassenger.getCardNumber());

        PassengerRepository.save(Passenger);

        return Passenger;
    }
    
}
