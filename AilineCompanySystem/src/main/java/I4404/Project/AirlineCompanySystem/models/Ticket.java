package I4404.Project.AirlineCompanySystem.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private long TicketId ;
    private long flightId ;
    private long  PassengerId ;
    private String MealType ;
    private Long Price ;
    private String SeatType ;

    public long getTicketId() {
        return TicketId;
    }

    public void setTicketId(long ticketId) {
        TicketId = ticketId;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public long getPassengerId() {
        return PassengerId;
    }

    public void setPassengerId(long passengerId) {
        PassengerId = passengerId;
    }

    public String getMealType() {
        return MealType;
    }

    public void setMealType(String mealType) {
        MealType = mealType;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public String getSeatType() {
        return SeatType;
    }

    public void setSeatType(String seatType) {
        SeatType = seatType;
    }
}
