package I4404.Project.AirlineCompanySystem.services;

import I4404.Project.AirlineCompanySystem.SeatState.SeatStateContext;
import I4404.Project.AirlineCompanySystem.models.Flight;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    public void  ManageSeats(Flight flight , String TypeOfSeat){
        SeatStateContext.UpdateNumberOfSeats(TypeOfSeat , flight);
    }

}
