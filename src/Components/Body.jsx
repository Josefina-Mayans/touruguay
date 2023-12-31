import React from "react";
import "../index.css";
import "../App.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import Card from "./Card";

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
            <h2> Recomendados de esta semana</h2>
            <div className="flex flex-wrap">
                <Card />
                <Card />
                <Card />
                <Card />
                <Card />
            </div>
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
        </body >
    );
}

export default Body;
