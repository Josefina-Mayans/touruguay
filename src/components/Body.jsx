import React from "react";
import "../App.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

function Body() {
    return (
        <body>
            <section className="buscador">
                <input
                    type="search"
                    placeholder="Salto en paracaídas, tour por la ciudad..."
                ></input>
                <FontAwesomeIcon
                    className="searchIcon"
                    icon="fas fa-search"
                ></FontAwesomeIcon>
            </section>
            <section className="displayHome">
                <h2> Recomendados de esta semana</h2>
                <div>
                    <img src="1.png" alt="Desayuno" />
                    <img src="2.png" alt="Brunch" />
                    <img src="3.png" alt="Gourmet" />
                    <img src="4.png" alt="Relax" />
                </div>
            </section>
            <section className="cat">
                <h2>Busca por categorías</h2>
                <div>
                    <ul>
                        <li> Gastronomía</li>
                        <li>Bienestar</li>
                        <li>Aventura</li>
                        <li>Cursos y talleres</li>
                    </ul>
                    <ul>
                        <li> Imperdibles</li>
                        <li>Extremos</li>
                        <li>Paseos</li>
                        <li>Místico</li>
                    </ul>
                </div>
            </section>
            <section className="footer">
                <div className="logoFooter">
                    <img src="TOURuguaySinFondo.png" alt="Logo" />
                </div>
                <h5>© 2020-2023 TOURuguay, Inc. Todos los derechos reservados.</h5>
            </section>
        </body>
    );
}

export default Body;
