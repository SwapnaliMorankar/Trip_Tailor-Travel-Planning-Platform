import React from 'react';
import HomeAbout from '/HomeAbout.png';
import './AboutTripTailor.css';

const AboutTripTailor = () => {
  return (
    <div className="homeabout">
      <img src={HomeAbout} alt="Image" />
      <div className="triptailorheading">
        <h1>TRIP TAILOR</h1>
        <p>
          "Welcome to TripTailor, where your journey begins! We specialize in creating 
          personalized travel experiences that match your unique preferences and dreams. 
          Whether it’s a weekend getaway, a grand adventure, or a relaxing retreat, our 
          intuitive tools and expert recommendations help you plan every detail with ease. 
          Let’s tailor your perfect trip and turn your wanderlust into unforgettable memories!"
        </p>
      </div>
    </div>
  );
};

export default AboutTripTailor;
