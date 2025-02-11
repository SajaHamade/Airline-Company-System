package I4404.Project.AirlineCompanySystem.SeatState.ConcreteStates;

import I4404.Project.AirlineCompanySystem.SeatState.SeatState;
import I4404.Project.AirlineCompanySystem.models.Flight;

public class BusinessSeatState implements SeatState {
    @Override
    public void bookSeat(Flight flight) {
        if (flight.getBusinessSeats() > 0) {
            flight.setBusinessSeats(flight.getBusinessSeats() - 1);
        } else {
            throw new RuntimeException("No available Business seats.");
        }
    }
}
