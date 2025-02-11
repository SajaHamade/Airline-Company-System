import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";

const Navbar = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userId, setUserId] = useState(null);

  useEffect(() => {
    const storedUserId = localStorage.getItem("userId");
    if (storedUserId) {
      setIsLoggedIn(true);
      setUserId(storedUserId);
    }
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("userId");
    setIsLoggedIn(false);
    setUserId(null);
    window.location.href = "/"; // Redirect after logout
  };

  return (
    <nav className="navbar">
   <div className="app-name">
  <Link to="/" style={{ textDecoration: 'none' }}>Airline Company System</Link>
</div>
      <div>
        {isLoggedIn ? (
          <>
            <button onClick={() => window.location.href = `/notifications/${userId}`}>
              Check Notifications
            </button>
            <button onClick={handleLogout}>Logout</button>
          </>
        ) : (
          <Link to="/login">
            <button>Login</button>
          </Link>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
