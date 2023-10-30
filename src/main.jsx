import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import Navbar from './components/Navbar';
import Body from './components/Body';
import Footer from "./Components/Footer";
import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

library.add(fas);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <FontAwesomeIcon />
    <App />
    <Navbar />
    <Body />
    <Footer />
  </React.StrictMode>,
)
