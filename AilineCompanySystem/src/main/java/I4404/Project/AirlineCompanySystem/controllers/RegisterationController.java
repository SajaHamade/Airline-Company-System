package I4404.Project.AirlineCompanySystem.controllers;


import I4404.Project.AirlineCompanySystem.models.Passenger;
import I4404.Project.AirlineCompanySystem.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
@RequestMapping("/users")
public class RegisterationController {
    private RegistrationService RegistrationService ;

   @Autowired
    public RegisterationController(RegistrationService registrationService) {
        RegistrationService = registrationService;
    }

    @PostMapping("/register")
    public Passenger newPassenger(@RequestBody Passenger newPassenger){
       return  RegistrationService.RegisterPassenger(newPassenger);
    }






}
