import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Home.css";

const Home = () => {
  const [searchData, setSearchData] = useState({
    origin: "",
    destination: "",
    date: "",
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setSearchData({ ...searchData, [e.target.name]: e.target.value });
  };

  const handleSearch = () => {
    if (!searchData.origin || !searchData.destination || !searchData.date) {
      alert("Please fill in all fields!");
      return;
    }
    
    navigate(`/flightdisplay/${searchData.origin}/${searchData.destination}/${searchData.date}`);
  };

  return (
    <div className="home-container">
      <div className="overlay"></div>
      <div className="content">
        <h1>Find Your Perfect Flight</h1>
        <p>Explore the world with the best travel deals</p>
        <div className="search-bar">
          <input
            type="text"
            name="origin"
            placeholder="Origin"
            value={searchData.origin}
            onChange={handleChange}
          />
          <input
            type="text"
            name="destination"
            placeholder="Destination"
            value={searchData.destination}
            onChange={handleChange}
          />
          <input
            type="date"
            name="date"
            value={searchData.date}
            onChange={handleChange}
          />
          <button onClick={handleSearch}>Search</button>
        </div>
      </div>
    </div>
  );
};

export default Home;
