// Login.js
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './Login.css';

const Login = () => {
    const [formData, setFormData] = useState({
        email: '',
        password: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Login form data:', formData);
    };

    return (
        <div className="login-page">
            <div className="login-container">
                <h1>Login</h1>
                <form onSubmit={handleSubmit} className="login-form">
                    <input
                        type="email"
                        name="email"
                        placeholder="Email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                    <input
                        type="password"
                        name="password"
                        placeholder="Password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                    <button type="submit" className="login-button">Login</button>
                </form>
                <p className="login-footer">
                    Don't have an account yet?{' '}
                    <Link to="/register" className="register-link">Sign up here!</Link>
                </p>
            </div>
        </div>
    );
};

export default Login;
