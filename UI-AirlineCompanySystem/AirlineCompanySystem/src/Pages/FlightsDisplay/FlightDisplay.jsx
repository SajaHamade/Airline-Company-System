import React from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";
import "./FlightDisplay.css";
import { useEffect, useState } from "react";

const FlightDisplay = () => {
  const { origin, destination, date } = useParams();

  const [flights, setFlights] = useState([]);
  const [error, setError] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    console.log("Received params:", origin, destination, date);
    const fetchFlights = async () => {
      try {
        const response = await axios.post(
          `http://localhost:8080/flights/search/${origin}/${destination}/${date}`
        );
        setFlights(response.data);
      } catch (err) {
        setError(err.response?.data?.message || "No flights found.");
      }
    };
    fetchFlights();
  }, [origin, destination, date]);

  const handleBookFlight = (flightId) => {
    const passengerId =  localStorage.getItem("userId");
    console.log(passengerId , flightId);
    if(passengerId == null){
      navigate('/Login');
    }else{
    navigate(`/flight-booking/${flightId}/${passengerId}`);
    }
    
  };

  return (
    <div className="flight-container">
      <div className="flight-box">
        <h2>Available Flights</h2>
        {error && <p className="error-message">{error}</p>}
        {flights.length > 0 ? (
          <div className="flight-list">
            {flights.map((flight, index) => (
              <div key={index} className="flight-item">
                <p><strong>Origin:</strong> {flight.origin}</p>
                <p><strong>Destination:</strong> {flight.destination}</p>
                <p><strong>Departure Date:</strong> {flight.departureDate}</p>
                <p><strong>Departure Time:</strong> {flight.departureTime}</p>
                <p><strong>Time Interval:</strong> {flight.timeInterval}</p>
                <p><strong>Aircraft:</strong> {flight.aircraft}</p>
                <p><strong>Base Price:</strong> ${flight.basePrice}</p>
                <button onClick={() => handleBookFlight(flight.flighId)}>
                  Book Flight
                </button>
              </div>
            ))}
          </div>
        ) : null}
      </div>
    </div>
  );
};

export default FlightDisplay;
