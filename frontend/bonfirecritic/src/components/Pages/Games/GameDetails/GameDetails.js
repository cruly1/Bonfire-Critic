import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import './GameDetails.css';

const GameDetails = () => {
    const { title } = useParams();
    const [game, setGame] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        axios.get('http://localhost:8080/api/games/getAllGames')
            .then((response) => {
                const selectedGame = response.data.find((g) => g.title === decodeURIComponent(title));
                if (selectedGame) {
                    setGame(selectedGame);
                } else {
                    setError('Game not found');
                }
                setLoading(false);
            })
            .catch((error) => {
                console.error('Error fetching game details:', error);
                setError('Failed to load game details');
                setLoading(false);
            });
    }, [title]);

    if (loading) return <div className="loading">Loading game details...</div>;
    if (error) return <div className="error">{error}</div>;

    return (
        <div className="game-details-container">
            <h1 className="game-title">{game.title}</h1>
            <p><strong>Developer:</strong> {game.developer}</p>
            <p><strong>Release Date:</strong> {game.releaseDate}</p>
            <p><strong>Platforms:</strong> {game.platforms.join(', ')}</p>

            <h2>Minimum System Requirements</h2>
            <p><strong>CPU:</strong> {game.minSpecs.cpu}</p>
            <p><strong>RAM:</strong> {game.minSpecs.ram}</p>
            <p><strong>GPU:</strong> {game.minSpecs.gpu}</p>
            <p><strong>Storage:</strong> {game.minSpecs.storage}</p>

            <h2>Recommended System Requirements</h2>
            <p><strong>CPU:</strong> {game.recommendedSpecs.cpu}</p>
            <p><strong>RAM:</strong> {game.recommendedSpecs.ram}</p>
            <p><strong>GPU:</strong> {game.recommendedSpecs.gpu}</p>
            <p><strong>Storage:</strong> {game.recommendedSpecs.storage}</p>

            <h2>Main Voice Actors</h2>
            
                {game.actors.map((actor, index) => (
                    <li key={index}>{actor}</li>
                ))}
            
        </div>
    );
};

export default GameDetails;
