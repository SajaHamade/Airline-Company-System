import React, { useState } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";
import "./FlightBooking.css";

const FlightBooking = () => {
  const { flightId , passengerId } = useParams();
  const [typeOfSeat, setTypeOfSeat] = useState("Economy");
  const [mealPreference, setMealPreference] = useState("Vegetarian");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleBooking = async () => {
    setError("");
    try {
      const response = await axios.post(`http://localhost:8080/flights/book/${passengerId}/${flightId}`, null, {
        params: { TypeOfSeat: typeOfSeat, MealPreferences: mealPreference },
      });
      //navigate(`/ticket-display/${response.data.id}`);
      console.log(response);
      alert(`Successfully booked the trip with the following details:\n
        Meal Preference: ${response.data.mealType}\n
        Seat Type: ${response.data.seatType}\n
        Total Price: $${response.data.price}`);
        navigate('/');
      
    } catch (err) {
      setError(err.response?.data?.message || "Booking failed.");
    }
  };

  return (
    <div className="booking-container">
      <div className="booking-box">
        <h2>Flight Booking</h2>
        {error && <p className="error-message">{error}</p>}
        <label>Type of Seat:</label>    <p className="note">* Business class increases the price by $100</p>
        <select value={typeOfSeat} onChange={(e) => setTypeOfSeat(e.target.value)}>
          <option value="Business">Business</option>
          <option value="Economy">Economy</option>
        </select>
    
        <label>Meal Preference:</label>
        <select value={mealPreference} onChange={(e) => setMealPreference(e.target.value)}>
          <option value="Vegetarian">Vegetarian</option>
          <option value="Vegan">Vegan</option>
          <option value="Meats">Meats</option>
        </select>
        <button onClick={handleBooking}>Book Flight</button>
      </div>
    </div>
  );
};

export default FlightBooking;
