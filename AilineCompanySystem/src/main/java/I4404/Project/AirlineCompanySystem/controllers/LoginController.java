package I4404.Project.AirlineCompanySystem.controllers;

import I4404.Project.AirlineCompanySystem.FlightObserver.FlightObserverContext;
import I4404.Project.AirlineCompanySystem.models.Passenger;
import I4404.Project.AirlineCompanySystem.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
@RequestMapping("/users")
public class LoginController {
    private LoginService LoginService ;



    @Autowired
    public LoginController(LoginService LoginService) {
        this.LoginService = LoginService;
    }

    @PostMapping("/login/{username}/{password}")
    public Passenger authenticatePassenger(@PathVariable String username, @PathVariable String password) {
        return LoginService.authenticatePassenger(username, password);
    }

    @GetMapping("/notifications/{id}")
    public List<String> getAllNotifications(@PathVariable long id) {
        return FlightObserverContext.getNotifications(id);
    }



}
