package I4404.Project.AirlineCompanySystem.PricingStrategy.ConcreteStrategies;

import I4404.Project.AirlineCompanySystem.PricingStrategy.PricingStrategy;
import I4404.Project.AirlineCompanySystem.models.Flight;

public class EconomyPricingStrategy implements PricingStrategy {
    @Override
    public Long calculatePrice(Flight flight) {
        return flight.getBasePrice(); // Example base price for economy
    }
}
