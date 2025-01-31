import { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'; 
import HomePage from './Pages/HomePage';
import AboutPage from './Pages/AboutUsPage'; 
import ExplorePage from './Pages/ExplorePage'; 
import PlanPage from './Pages/PlanTripPage'; 
import ContactPage from './Pages/ContactPage'; 
import Footer from './Components/Footer/Footer';
import Navbar from './Components/Navbar/Navbar';

function App() {
  const [count, setCount] = useState(0);

  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/explore" element={<ExplorePage />} />
        <Route path="/plan" element={<PlanPage />} />
        <Route path="/contact" element={<ContactPage />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
