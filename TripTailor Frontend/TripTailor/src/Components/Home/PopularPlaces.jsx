import React from 'react';
import './PopularPlaces.css';
import Manali from '/Manali_City.jpg';
// import Konkan from '/Konkan.jpg';

const PopularPlaces = () => {
  return (
    <>
      <div className="popularheading">
        <h1>POPULAR DESTINATIONS</h1>
      </div>

      {/* Destination Card: Image on the Left */}
      <div className="destination-card">
        <img src={Manali} alt="Manali" className="destination-image" />
        <div className="destination-info">
          <h2>MANALI</h2>
          <p>Destinations: Solang Valley, Rohtang Pass, Old Manali, Hadimba Temple, Vashisht Hot Springs, Manu Temple</p>
          <p>Duration: 5 Days, 4 Nights</p>
          <p>Budget: 7999/- per person</p>
        </div>
      </div>

      {/* Destination Card: Image on the Right */}
      <div className="destination-card reverse">
        <div className="destination-info">
          <h2>KONKAN</h2>
          <p>Destinations: Ganpatipule, Ratnagiri, Sindhudurg Fort, Tarkarli Beach, Murud-Janjira, Diveagar Beach</p>
          <p>Duration: 5 Days, 4 Nights</p>
          <p>Budget: 7999/- per person</p>
        </div>
        <img src={Manali} alt="Konkan" className="destination-image" />
      </div>
    </>
  );
};

export default PopularPlaces;
