package I4404.Project.AirlineCompanySystem.SeatState;


import I4404.Project.AirlineCompanySystem.PricingStrategy.ConcreteStrategies.BusinessPricingStrategy;
import I4404.Project.AirlineCompanySystem.PricingStrategy.ConcreteStrategies.EconomyPricingStrategy;
import I4404.Project.AirlineCompanySystem.SeatState.ConcreteStates.BusinessSeatState;
import I4404.Project.AirlineCompanySystem.SeatState.ConcreteStates.EconomySeatState;
import I4404.Project.AirlineCompanySystem.models.Flight;

public class SeatStateContext {
    static SeatState State ;

    public static void UpdateNumberOfSeats(String SeatType, Flight flight){
        switch (SeatType.toUpperCase()) {
            case "BUSINESS":
                State = new BusinessSeatState();
                break;
            case "ECONOMY":
            default:
                State = new EconomySeatState();
                break;
        }

       State.bookSeat(flight);
    }

}


