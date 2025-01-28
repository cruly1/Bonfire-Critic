// Navbar.js
import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Navbar.css';

const Navbar = () => {
    const navigate = useNavigate();
    const [searchTerm, setSearchTerm] = useState('');
    const [searchResults, setSearchResults] = useState([]);
    const [showDropdown, setShowDropdown] = useState(false);

    useEffect(() => {
        if (searchTerm.trim().length > 0) {
            axios.get(`http://localhost:8080/api/games/searchGames/search?wd=${encodeURIComponent(searchTerm)}`)
                .then((response) => {
                    setSearchResults(response.data);
                    setShowDropdown(true);
                })
                .catch((error) => {
                    console.error('Error fetching search results:', error);
                    setSearchResults([]);
                    setShowDropdown(false);
                });
        } else {
            setSearchResults([]);
            setShowDropdown(false);
        }
    }, [searchTerm]);

    const handleSearchSubmit = (event) => {
        event.preventDefault();
        if (searchTerm.trim()) {
            navigate(`/games?search=${encodeURIComponent(searchTerm)}`, { state: { searchResults } });
            setShowDropdown(false);
        }
    };

    const handleResultClick = (gameTitle) => {
        navigate(`/games/${encodeURIComponent(gameTitle)}`);
        setSearchTerm('');
        setShowDropdown(false);
    };

    return (
        <nav className="navbar">
            <div className="navbar-logo" onClick={() => navigate('/')}>
                Bonfire Critic
            </div>
            <div className="navbar-search-container">
                <form className="navbar-search" onSubmit={handleSearchSubmit}>
                    <input
                        type="text"
                        name="search"
                        placeholder="Search games..."
                        className="search-input"
                        value={searchTerm}
                        onChange={(e) => setSearchTerm(e.target.value)}
                        onFocus={() => setShowDropdown(searchResults.length > 0)}
                    />
                    <button type="submit" className="search-button">
                        🔍
                    </button>
                </form>
                {showDropdown && searchResults.length > 0 && (
                    <ul className="search-dropdown">
                        {searchResults.map((game, index) => (
                            <li key={index} onClick={() => handleResultClick(game.title)} className="dropdown-item">
                                {game.title}
                            </li>
                        ))}
                    </ul>
                )}
            </div>
            <div className="navbar-links">
                <button className="navbar-button" onClick={() => navigate('/games')}>
                    Game Collection
                </button>
                <button className="navbar-button" onClick={() => navigate('/login')}>
                    Sign In / Sign Up
                </button>
            </div>
        </nav>
    );
};

export default Navbar;
