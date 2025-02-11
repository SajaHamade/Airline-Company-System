package I4404.Project.AirlineCompanySystem.SeatState.ConcreteStates;

import I4404.Project.AirlineCompanySystem.SeatState.SeatState;
import I4404.Project.AirlineCompanySystem.models.Flight;

public class EconomySeatState implements SeatState {
    @Override
    public void bookSeat(Flight flight) {
        if (flight.getEconomySeats() > 0) {
            flight.setEconomySeats(flight.getEconomySeats() - 1);
        } else {
            throw new RuntimeException("No available Economy seats.");
        }
    }

}
