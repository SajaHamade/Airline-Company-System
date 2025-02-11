import {BrowserRouter , Routes , Route } from 'react-router-dom'

import Home from './Home'
import Navbar from './Navbar/Navbar'
import EditFlight from './Pages/EditFlight/EditFlight'
import AddFlight from './Pages/AddFlight/AddFlight'

function App() {


  return (
    <BrowserRouter>
    <Navbar />
    <Routes>
      <Route path='/' element={<Home />}/>
      <Route path='/update-flight/:flightId' element={<EditFlight/>}/>
      <Route path='/add-flight' element={<AddFlight />}/>
    </Routes>
    </BrowserRouter>
  
  )
}

export default App
