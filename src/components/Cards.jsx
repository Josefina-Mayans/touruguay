import Card from "./Card";
import image1 from '/1.png'
import image2 from '/2.png'
import image3 from '/3.png'
import image4 from '/4.png'
import React, { useState, useEffect } from 'react';

const cards = [
    {
        id: 1,
        title: 'Producto 1',
        image: image1,
    },
    {
        id: 2,
        title: 'Producto 2',
        image: image2,
    },
    {
        id: 3,
        title: 'Producto 3',
        image: image3,
    },
    {
        id: 4,
        title: 'Producto 4',
        image: image4,
    }
    // Agrega aquí tus tarjetas
];

function Cards() {
    const [randomCards, setRandomCards] = useState([]);

    useEffect(() => {
        setRandomCards(cards.sort(() => Math.random() - 0.5));
    }, []);

    return (
        <div className='container d-flex justify-content-center align-items-center'>
            <div className='row'>
                {
                    randomCards.map(card => (
                        <div className='col-md-5 mt-5' key={card.id}>
                            <img className='imagen-card' src={card.image} />
                            <div className='content-card'>
                                <Card title={card.title} />
                            </div>
                        </div>
                    ))
                }
            </div>
        </div>
    )
}

export default Cards;