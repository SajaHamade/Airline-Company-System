import {BrowserRouter , Route , Routes} from 'react-router-dom'
import Register from './Pages/Registration/Register'
import Login from './Pages/Login/Login'
import Home from './Home'
import Navbar from './Navbar/Navbar'
import FlightDisplay from './Pages/FlightsDisplay/FlightDisplay'
import FlightBooking from './Pages/FlightBooking/FlightBooking'
import Notifications from './Pages/Notifications/Notifications'




function App() {


  return (
  <BrowserRouter>
  <Navbar />
  <Routes>
  <Route path='/' element={<Home/>}/>
  <Route path='/Register' element={<Register/>}/>
  <Route path='/Login' element={<Login/>}/>
  <Route path='/flightdisplay/:origin/:destination/:date' element={<FlightDisplay />} />
  <Route path='/flight-booking/:flightId/:passengerId' element={<FlightBooking />} />
  <Route path='/notifications/:userId' element={<Notifications />} />


  </Routes>
  </BrowserRouter>
  )
}

export default App
