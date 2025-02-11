package I4404.Project.AirlineCompanySystem.PricingStrategy;

import I4404.Project.AirlineCompanySystem.models.Flight;

public interface PricingStrategy {
    Long calculatePrice(Flight flight );
}
