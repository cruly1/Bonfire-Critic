// Navbar.js
import React from 'react';
import { useNavigate } from 'react-router-dom';
import './Navbar.css';

const Navbar = () => {
    const navigate = useNavigate();

    const handleSearch = (event) => {
        event.preventDefault();
        const searchTerm = event.target.search.value.trim();
        if (searchTerm) {
            navigate(`/games?search=${encodeURIComponent(searchTerm)}`);
        }
    };

    return (
        <nav className="navbar">
            <div className="navbar-logo" onClick={() => navigate('/')}>
                Bonfire Critic
            </div>
            <form className="navbar-search" onSubmit={handleSearch}>
                <input
                    type="text"
                    name="search"
                    placeholder="Search games..."
                    className="search-input"
                />
                <button type="submit" className="search-button">
                    🔍
                </button>
            </form>
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
