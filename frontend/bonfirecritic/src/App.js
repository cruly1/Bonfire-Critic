import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import Navbar from './components/Navbar/Navbar.js';
import Footer from './components/Footer/Footer.js';
import Home from './components/Pages/Home/Home.js';
import Games from './components/Pages/Games/Games.js';
import Login from './components/Pages/Login/Login.js';
import Register from './components/Pages/Register/Register.js';
import GameDetails from './components/Pages/Games/GameDetails/GameDetails.js';

const sampleGame = {
    title: 'The Legend of Bonfire',
    description: 'An epic adventure game where you gather resources, build bonfires, and battle mythical creatures.',
    rating: 4.8,
    favorites: 245,
    releaseDate: '2023-05-01',
};

function App() {
    return (
        <Router>
            <div className="App">
                <Navbar />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/games" element={<Games />} />
                    <Route path="/games/:title" element={<GameDetails />} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/register" element={<Register />} />
                </Routes>
                <Footer />
            </div>
        </Router>
    );
}

export default App;
