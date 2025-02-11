package I4404.Project.AirlineCompanySystem.services;



import I4404.Project.AirlineCompanySystem.PricingStrategy.PricingStrategyContext;
import I4404.Project.AirlineCompanySystem.models.Flight;
import org.springframework.stereotype.Service;

@Service
public class PricingService {

    public Long calculateTicketPrice(String SeatType , Flight flight) {
        return PricingStrategyContext.calculateTicketPrice(SeatType , flight) ;

    }

}