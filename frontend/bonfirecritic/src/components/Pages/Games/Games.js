import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import './Games.css';

const Games = () => {
    const [games, setGames] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [filterFavorites, setFilterFavorites] = useState(false);
    const [sortCriteria, setSortCriteria] = useState('releaseDate');

    const navigate = useNavigate();
    const location = useLocation();
    const searchResults = location.state?.searchResults || null;
    const searchQuery = new URLSearchParams(location.search).get('search');

    useEffect(() => {
        if (searchResults) {
            setGames(searchResults);
            setLoading(false);
        } else {
            axios.get('http://localhost:8080/api/games/getAllGames')
                .then((response) => {
                    setGames(response.data);
                    setLoading(false);
                })
                .catch((error) => {
                    console.error('Error fetching games:', error);
                    setError('Failed to load games');
                    setLoading(false);
                });
        }
    }, [searchResults]);

    const filteredGames = filterFavorites ? games.filter((game) => game.favorites > 100) : games;

    const sortedGames = [...filteredGames].sort((a, b) => {
        if (sortCriteria === 'releaseDate') return new Date(b.releaseDate) - new Date(a.releaseDate);
        return 0;
    });

    const handleGameClick = (gameTitle) => {
        navigate(`/games/${encodeURIComponent(gameTitle)}`);
    };

    if (loading) return <div className="loading">Loading games...</div>;
    if (error) return <div className="error">{error}</div>;

    return (
        <div className="games-container">
            <header className="games-header">
                <h1>Game Collection</h1>
                {searchQuery && <p className="search-result-text">Showing results for: <strong>{searchQuery}</strong></p>}
                <div className="filters">
                    <label>
                        <input
                            type="checkbox"
                            checked={filterFavorites}
                            onChange={() => setFilterFavorites(!filterFavorites)}
                        />
                        Show Only Favorites (&lt; 100)
                    </label>
                    <select
                        value={sortCriteria}
                        onChange={(e) => setSortCriteria(e.target.value)}
                        className="sort-dropdown"
                    >
                        <option value="releaseDate">Sort by Release Date</option>
                    </select>
                </div>
            </header>
            <ul className="games-list">
                {sortedGames.length > 0 ? (
                    sortedGames.map((game, index) => (
                        <li key={index} className="game-item" onClick={() => handleGameClick(game.title)}>
                            <h2>{game.title}</h2>
                            <p><strong>Developer:</strong> {game.developer}</p>
                            <p><strong>Release Date:</strong> {game.releaseDate}</p>
                            <p><strong>Platforms:</strong> {game.platforms.join(', ')}</p>
                        </li>
                    ))
                ) : (
                    <p className="no-results">No games found for "{searchQuery}"</p>
                )}
            </ul>
        </div>
    );
};

export default Games;
