import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";
import "./EditFlight.css";

const EditFlight = () => {
  const { flightId } = useParams();
  const navigate = useNavigate();
  const [flight, setFlight] = useState(null);
  const [formData, setFormData] = useState({});
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchFlight = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/flights/${flightId}`);
        setFlight(response.data);
        setFormData(response.data); // Autofill form
        setLoading(false);
      } catch (err) {
        setError(err.response?.data?.message || "Failed to fetch flight details.");
        setLoading(false);
      }
    };

    fetchFlight();
  }, [flightId]);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleUpdate = async () => {
    try {
      await axios.put(`http://localhost:8080/flights/update/${flightId}`, formData);
      alert("Flight updated successfully");
      navigate("/"); 
    } catch (err) {
      setError(err.response?.data?.message || "Update failed.");
    }
  };

  if (loading) return <p>Loading flight details...</p>;

  return (
    <div className="edit-flight-container">
      <div className="edit-flight-box">
        <h2>Edit Flight</h2>
        {error && <p className="error-message">{error}</p>}
        {flight && (
          <form>
            <label>Origin:</label>
            <input type="text" name="origin" value={formData.origin} onChange={handleChange} />
            <br />
            <br />

            <label>Destination:</label>
            <input type="text" name="destination" value={formData.destination} onChange={handleChange} />
            <br />
            <br />
            <label>Departure Date:</label>
            <input type="date" name="departureDate" value={formData.departureDate} onChange={handleChange} />
            <br />
            <br />
            <label>Departure Time:</label>
            <input type="time" name="departureTime" value={formData.departureTime} onChange={handleChange} />
            <br />
            <br />
            <label>Time Interval:</label>
            <input type="text" name="timeInterval" value={formData.timeInterval} onChange={handleChange} />
            <br />
            <br />
            <label>Aircraft:</label>
            <input type="text" name="aircraft" value={formData.aircraft} onChange={handleChange} />
            <br />
            <br />
            <label>Base Price ($):</label>
            <input type="number" name="basePrice" value={formData.basePrice} onChange={handleChange} />
            <br />
            <br />
            <label>Economy Seats:</label>
            <input type="number" name="economySeats" value={formData.economySeats} onChange={handleChange} />
            <br />
            <br />
            <label>Business Seats:</label>
            <input type="number" name="businessSeats" value={formData.businessSeats} onChange={handleChange} />
            <br />
 
            <button type="button" onClick={handleUpdate}>Update Flight</button>
          </form>
        )}
      </div>
    </div>
  );
};

export default EditFlight;
