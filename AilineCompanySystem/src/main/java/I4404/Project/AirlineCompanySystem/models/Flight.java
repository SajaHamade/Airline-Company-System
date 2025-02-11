package I4404.Project.AirlineCompanySystem.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Long FlighId ;
    private String origin ;
    private  String destination ;
    private String departureDate;
    private String DepartureTime;
    private String TimeInterval ;
    private String Aircraft ;
    private Long BasePrice ;
    private Integer EconomySeats ;
    private  Integer BusinessSeats ;

    public Long getFlighId() {
        return FlighId;
    }

    public void setFlighId(Long flighId) {
        FlighId = flighId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public String getTimeInterval() {
        return TimeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        TimeInterval = timeInterval;
    }

    public String getAircraft() {
        return Aircraft;
    }

    public void setAircraft(String aircraft) {
        Aircraft = aircraft;
    }

    public Long getBasePrice() {
        return BasePrice;
    }

    public void setBasePrice(Long basePrice) {
        BasePrice = basePrice;
    }

    public Integer getEconomySeats() {
        return EconomySeats;
    }

    public void setEconomySeats(Integer economySeats) {
        EconomySeats = economySeats;
    }

    public Integer getBusinessSeats() {
        return BusinessSeats;
    }

    public void setBusinessSeats(Integer businessSeats) {
        BusinessSeats = businessSeats;
    }
}
