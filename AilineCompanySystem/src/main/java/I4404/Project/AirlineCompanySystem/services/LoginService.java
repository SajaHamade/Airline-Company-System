package I4404.Project.AirlineCompanySystem.services;

import I4404.Project.AirlineCompanySystem.models.Passenger;
import I4404.Project.AirlineCompanySystem.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LoginService {
    private PassengerRepository PassengerRepository ;


    @Autowired
    public LoginService(PassengerRepository PassengerRepository) {
        this.PassengerRepository = PassengerRepository ;
    }


    public Passenger authenticatePassenger(String username, String password) {
        Passenger Passenger = PassengerRepository.findByUsernameAndPassword(username, password);
        if (Passenger != null ) {
            return Passenger;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Passengername or password");
        }
    }

}
