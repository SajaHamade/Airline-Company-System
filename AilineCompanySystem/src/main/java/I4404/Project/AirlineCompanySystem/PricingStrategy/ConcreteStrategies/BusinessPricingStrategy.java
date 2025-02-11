package I4404.Project.AirlineCompanySystem.PricingStrategy.ConcreteStrategies;

import I4404.Project.AirlineCompanySystem.PricingStrategy.PricingStrategy;
import I4404.Project.AirlineCompanySystem.models.Flight;

public class BusinessPricingStrategy implements PricingStrategy {
    @Override
    public Long calculatePrice(Flight flight) {
        return flight.getBasePrice() + 100 ; // Add $100 to base price
    }
}
