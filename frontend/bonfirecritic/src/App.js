import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import Navbar from './components/Navbar/Navbar.js';
import Footer from './components/Footer/Footer.js';
import Home from './components/Pages/Home/Home.js';
import Games from './components/Pages/Games/Games.js';

function App() {
    return (
        <Router>
            <div className="App">
                <Navbar />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/games" element={<Games />} />
                    <Route path="/login" element={<div>Login/Register Page</div>} />
                </Routes>
                <Footer />
            </div>
        </Router>
    );
}

export default App;
