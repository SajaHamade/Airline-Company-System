import { Link } from "react-router-dom";
import "./Navbar.css";

const Navbar = () => {
  return (
    <nav className="admin-navbar">
      <div className="admin-title">Admin Panel</div>
      <div>
        <Link to="/add-flight">
          <button>Add Flight</button>
        </Link>
      </div>
    </nav>
  );
};

export default Navbar;
