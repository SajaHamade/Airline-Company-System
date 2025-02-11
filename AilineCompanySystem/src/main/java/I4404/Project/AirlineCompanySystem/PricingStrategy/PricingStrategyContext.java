package I4404.Project.AirlineCompanySystem.PricingStrategy;

import I4404.Project.AirlineCompanySystem.PricingStrategy.ConcreteStrategies.BusinessPricingStrategy;
import I4404.Project.AirlineCompanySystem.PricingStrategy.ConcreteStrategies.EconomyPricingStrategy;
import I4404.Project.AirlineCompanySystem.models.Flight;

public class PricingStrategyContext {
    static PricingStrategy strategy;
    public static Long calculateTicketPrice(String SeatType, Flight flight) {
        switch (SeatType.toUpperCase()) {
            case "BUSINESS":
                strategy = new BusinessPricingStrategy();
                break;
            case "ECONOMY":
            default:
                strategy = new EconomyPricingStrategy();
                break;
        }

        return strategy.calculatePrice(flight);
    }
}
