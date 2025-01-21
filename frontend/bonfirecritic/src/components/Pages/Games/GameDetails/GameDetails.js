import React from 'react';
import { useParams } from 'react-router-dom';
import './GameDetails.css';

const gamesData = [
    { id: 1, title: 'Game 1', description: 'Description of Game 1', rating: 4.5, favorites: 150, releaseDate: '2023-06-15' },
    { id: 2, title: 'Game 2', description: 'Description of Game 2', rating: 3.8, favorites: 100, releaseDate: '2022-10-10' },
    { id: 3, title: 'Game 3', description: 'Description of Game 3', rating: 5.0, favorites: 200, releaseDate: '2021-12-01' },
    { id: 4, title: 'Game 4', description: 'Description of Game 4', rating: 4.0, favorites: 120, releaseDate: '2020-08-22' },
    { id: 5, title: 'Game 5', description: 'Description of Game 5', rating: 3.2, favorites: 80, releaseDate: '2024-01-10' },
];

const GameDetails = () => {
    const { id } = useParams();
    const game = gamesData.find((game) => game.id === parseInt(id));

    if (!game) {
        return <div className="game-details-container">Game not found.</div>;
    }

    return (
        <div className="game-details-container">
            <h1 className="game-title">{game.title}</h1>
            <p className="game-description">{game.description}</p>
            <div className="game-info">
                <p><strong>Rating:</strong> {game.rating}</p>
                <p><strong>Favorites:</strong> {game.favorites}</p>
                <p><strong>Release Date:</strong> {game.releaseDate}</p>
            </div>
        </div>
    );
};

export default GameDetails;
