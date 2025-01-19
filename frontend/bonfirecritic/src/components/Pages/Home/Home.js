// Home.js
import React from 'react';
import bonfireLogo from '../../../assets/bonfire_logo.png'; // Correct import path for the image
import './Home.css';
import { useNavigate } from 'react-router-dom';

const Home = () => {
    const navigate = useNavigate();

    return (
        <div className="home-container">
            <header className="home-header">
                <h1>Welcome to Bonfire Critic</h1>
                <p>Your ultimate hub to rate, favorite, and discuss your favorite games!</p>
            </header>
            <section className="bonfire-intro">
                <div className="bonfire-visual">
                    <img src={bonfireLogo} alt="Bonfire Illustration" className="bonfire-image" />
                </div>
                <p className="tagline">Gather around the bonfire and share your thoughts on the latest and greatest games.</p>
            </section>
            <section className="game-categories">
                <h2>Explore Games</h2>
                <div className="categories">
                    <div className="category-card" onClick={() => navigate('/games?filter=new-releases')}>New Releases</div>
                    <div className="category-card" onClick={() => navigate('/games?filter=top-rated')}>Top Rated</div>
                    <div className="category-card" onClick={() => navigate('/games?filter=community-favorites')}>Community Favorites</div>
                </div>
            </section>
            <footer className="home-footer">
                <p>&copy; 2025 Bonfire Critic | Let your gaming voice be heard.</p>
            </footer>
        </div>
    );
};

export default Home;
