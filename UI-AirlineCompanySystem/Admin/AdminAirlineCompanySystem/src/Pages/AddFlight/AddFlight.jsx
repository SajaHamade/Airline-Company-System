import React, { useState } from "react";
import axios from "axios";
import "./AddFlight.css";

const AddFlight = () => {
  const [flight, setFlight] = useState({
    origin: "",
    destination: "",
    departureDate: "",
    departureTime: "",
    timeInterval: "",
    aircraft: "",
    basePrice: "",
    economySeats: "",
    businessSeats: "",
  });

  const [message, setMessage] = useState("");
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setFlight({ ...flight, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage("");
    setError("");
    try {
      const response = await axios.post("http://localhost:8080/flights/add", flight);
      alert("Flight Added Successfully");
      window.location.href="/";
      setFlight({
        origin: "",
        destination: "",
        departureDate: "",
        departureTime: "",
        timeInterval: "",
        aircraft: "",
        basePrice: "",
        economySeats: "",
        businessSeats: "",
      });
    } catch (err) {
      setError(err.response?.data?.message || "Failed to add flight.");
    }
  };

  return (
    <div className="add-flight-container">
      <div className="add-flight-box">
        <h2>Add Flight</h2>
        {error && <p className="error-message">{error}</p>}
        {message && <p className="success-message">{message}</p>}
        <form onSubmit={handleSubmit}>
          <label>Origin:</label>
          <input type="text" name="origin" value={flight.origin} onChange={handleChange} required />

          <label>Destination:</label>
          <input type="text" name="destination" value={flight.destination} onChange={handleChange} required />

          <label>Departure Date:</label>
          <input type="date" name="departureDate" value={flight.departureDate} onChange={handleChange} required />

          <label>Departure Time:</label>
          <input type="time" name="departureTime" value={flight.departureTime} onChange={handleChange} required />

          <label>Time Interval:</label>
          <input type="text" name="timeInterval" value={flight.timeInterval} onChange={handleChange} required />

          <label>Aircraft:</label>
          <input type="text" name="aircraft" value={flight.aircraft} onChange={handleChange} required />

          <label>Base Price ($):</label>
          <input type="number" name="basePrice" value={flight.basePrice} onChange={handleChange} required />

          <label>Economy Seats:</label>
          <input type="number" name="economySeats" value={flight.economySeats} onChange={handleChange} required />

          <label>Business Seats:</label>
          <input type="number" name="businessSeats" value={flight.businessSeats} onChange={handleChange} required />

          <button type="submit">Add Flight</button>
        </form>
      </div>
    </div>
  );
};

export default AddFlight;
