import React from 'react'
import './HeaderImage.css'
import HomeHeader from '/HomeHeader.png'

const HeaderImage = () => {
  return (
    <div>

        <div className="homeimagecontainer">
          <img src={HomeHeader} alt="Homeheader" />
        </div>

        <div className="hometextcontainer">
            <div className="hometext1">
                <h1>TURNING TRAVEL DREAMS <br /> INTO REALITY</h1>
            </div>
            <div className="hometext2">
                <p>Embark on a journey like never before—seamlessly plan, customize, and <br /> bring your travel 
                  dreams to life with us!</p>
            </div>
            <div className="hometext3">
                <button>Get Started</button>
            </div>
        </div>

    </div>
  )
}

export default HeaderImage