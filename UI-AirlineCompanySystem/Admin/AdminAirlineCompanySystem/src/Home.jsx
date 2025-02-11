import { useEffect, useState } from "react";
import axios from "axios";
import "./Home.css";

const Home = () => {
  const [flights, setFlights] = useState([]);

  useEffect(() => {
    // Fetch all flights from the backend
    axios
      .get("http://localhost:8080/flights/")
      .then((response) => setFlights(response.data))
      .catch((error) => console.error("Error fetching flights:", error));
  }, []);

  const handleUpdate = (flightId) => {
    
    window.location.href = `/update-flight/${flightId}`;
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/flights/delete/${id}`);
      alert("Flight will be deleted");
      window.location.href='/';
    //  setFlights(flights.filter((flight) => flight.FlighId !== id));
    } catch (error) {
      console.error("Error deleting flight:", error);
    }
  };

  return (
    <div className="home-container">
      {flights.length > 0 ? (
        flights.map((flight) => (
          <div key={flight.flighId} className="flight-card">
            <div className="flight-info">
              <h3>{flight.origin} ➝ {flight.destination}</h3>
              <p><strong>Departure Date:</strong> {flight.departureDate}</p>
              <p><strong>Departure Time:</strong> {flight.departureTime}</p>
              <p><strong>Duration:</strong> {flight.timeInterval}</p>
              <p><strong>Aircraft:</strong> {flight.aircraft}</p>
              <p><strong>Base Price:</strong> ${flight.basePrice}</p>
              <p><strong>Economy Seats:</strong> {flight.economySeats}</p>
              <p><strong>Business Seats:</strong> {flight.businessSeats}</p>
            </div>
            <div className="flight-actions">
              <button className="update-btn" onClick={() => handleUpdate(flight.flighId)}>Update</button>
              <button className="delete-btn" onClick={() => handleDelete(flight.flighId)}>Delete</button>
            </div>
          </div>
        ))
      ) : (
        <p className="no-flights">No flights available.</p>
      )}
    </div>
  );
};

export default Home;
