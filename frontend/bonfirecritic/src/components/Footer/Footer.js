// Footer.js
import React from 'react';
import './Footer.css';

const Footer = () => {
    return (
        <footer className="footer">
            <div className="footer-content">
                <p>&copy; 2025 Bonfire Critic | Let your gaming voice be heard.</p>
                <p>
                    Follow us on:
                    <a href="https://twitter.com" target="_blank" rel="noopener noreferrer" className="social-link"> Twitter</a> | 
                    <a href="https://facebook.com" target="_blank" rel="noopener noreferrer" className="social-link"> Facebook</a> | 
                    <a href="https://instagram.com" target="_blank" rel="noopener noreferrer" className="social-link"> Instagram</a>
                </p>
            </div>
        </footer>
    );
};

export default Footer;
