import { useState } from "react";
import axios from "axios";
import "./Register.css";


const Register = () => {
  const [formData, setFormData] = useState({
    username: "",
    name: "",
    email: "",
    password: "",
    cardNumber: ""
  });

  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setSuccess("");

    try {
      const response = await axios.post("http://localhost:8080/users/register", formData, {
        headers: { "Content-Type": "application/json" },
      });
      setSuccess("Registration successful!");
      setFormData({ username: "", name: "", email: "", password: "", cardNumber: "" });
      window.location.href = "/Login"; 
    } catch (err) {
      setError(err.response?.data?.message || "An error occurred");
    }
  };

  return (
    <div className="register-container">
      <div className="register-box">
        <h2>Register</h2>
        {error && <p className="error-message">{error}</p>}
        {success && <p className="success-message">{success}</p>}
        <form onSubmit={handleSubmit}>
          <input type="text" name="username" placeholder="Username" value={formData.username} onChange={handleChange} required />
          <input type="text" name="name" placeholder="Name" value={formData.name} onChange={handleChange} required />
          <input type="email" name="email" placeholder="Email" value={formData.email} onChange={handleChange} required />
          <input type="password" name="password" placeholder="Password" value={formData.password} onChange={handleChange} required />
          <input type="text" name="cardNumber" placeholder="Card Number" value={formData.cardNumber} onChange={handleChange} required />
          <button type="submit">Register</button>
        </form>
      </div>
    </div>
  );
};

export default Register;
