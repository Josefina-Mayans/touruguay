import React from 'react';
import '../App.css'; 



function Navbar() {
  return (
    <nav className="navbar">
      <div className="logo">
        <img src="TOURuguaySinFondo.png" alt="Logo"/>
  
        <h3 className='eslogan'>Descubriendo el paisito</h3>
      </div>
      <ul className="nav-links">
        <li><a href="#">Iniciar sesion</a></li>
        <li><a href="#">Crear Cuenta</a></li>
      </ul>
    </nav>
  );
}

export default Navbar;