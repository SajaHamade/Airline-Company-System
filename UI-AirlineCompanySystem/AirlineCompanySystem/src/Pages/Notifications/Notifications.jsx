import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import "./Notifications.css";

const Notifications = () => {
  const { userId } = useParams();
  const [notifications, setNotifications] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchNotifications = async () => {
      const lastFetch = localStorage.getItem(`lastFetch_${userId}`);
      try {
        const response = await axios.get(`http://localhost:8080/users/notifications/${userId}`);
        const newNotifications = response.data;

        // Check if the fetched notifications are new
        if (newNotifications.length > 0 && lastFetch !== newNotifications[0].timestamp) {
          setNotifications(newNotifications);
          localStorage.setItem(`lastFetch_${userId}`, newNotifications[0].timestamp); // Save the new timestamp
        }
      } catch (err) {
        setError(err.response?.data?.message || "Failed to load notifications.");
      }
    };

    fetchNotifications();
  }, [userId]);

  return (
    <div className="notifications-container">
      <div className="notifications-box">
        <h2>Notifications</h2>
        {error ? (
          <p className="error-message">{error}</p>
        ) : notifications.length > 0 ? (
          <ul>
            {notifications.map((notification, index) => (
              <li key={index}>{notification}</li>
            ))}
          </ul>
        ) : (
          <p>No notifications available.</p>
        )}
      </div>
    </div>
  );
};

export default Notifications;
