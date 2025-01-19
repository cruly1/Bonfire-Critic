// Games.js
import React, { useState } from 'react';
import './Games.css';

const gamesData = [
    { id: 1, title: 'Game 1', rating: 4.5, favorites: 150, releaseDate: '2023-06-15' },
    { id: 2, title: 'Game 2', rating: 3.8, favorites: 100, releaseDate: '2022-10-10' },
    { id: 3, title: 'Game 3', rating: 5.0, favorites: 200, releaseDate: '2021-12-01' },
    { id: 4, title: 'Game 4', rating: 4.0, favorites: 120, releaseDate: '2020-08-22' },
    { id: 5, title: 'Game 5', rating: 3.2, favorites: 80, releaseDate: '2024-01-10' },
];

const Games = () => {
    const [filterFavorites, setFilterFavorites] = useState(false);
    const [sortCriteria, setSortCriteria] = useState('rating');

    const filteredGames = filterFavorites
        ? gamesData.filter((game) => game.favorites > 100)
        : gamesData;

    const sortedGames = [...filteredGames].sort((a, b) => {
        if (sortCriteria === 'rating') return b.rating - a.rating;
        if (sortCriteria === 'favorites') return b.favorites - a.favorites;
        if (sortCriteria === 'releaseDate') return new Date(b.releaseDate) - new Date(a.releaseDate);
        return 0;
    });

    return (
        <div className="games-container">
            <header className="games-header">
                <h1>Game List</h1>
                <div className="filters">
                    <label>
                        <input
                            type="checkbox"
                            checked={filterFavorites}
                            onChange={() => setFilterFavorites(!filterFavorites)}
                        />
                        'Show Only Favorites (  100)
                    </label>

                    <select
                        value={sortCriteria}
                        onChange={(e) => setSortCriteria(e.target.value)}
                        className="sort-dropdown"
                    >
                        <option value="rating">Sort by Rating</option>
                        <option value="favorites">Sort by Favorites</option>
                        <option value="releaseDate">Sort by Release Date</option>
                    </select>
                </div>
            </header>

            <ul className="games-list">
                {sortedGames.map((game) => (
                    <li key={game.id} className="game-item">
                        <h2>{game.title}</h2>
                        <p>Rating: {game.rating}</p>
                        <p>Favorites: {game.favorites}</p>
                        <p>Release Date: {game.releaseDate}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Games;