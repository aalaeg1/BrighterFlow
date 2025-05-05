import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Signup = () => {
  const [formData, setFormData] = useState({
    email: '',
    mot_de_passe: '',
    nom: '',
    role: 'USER'
  });
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/signup', formData);
      navigate('/login');
    } catch (error) {
      alert("Erreur d'inscription: " + (error.response?.data || error.message));
    }
  };

  return (
    <div className="auth-container">
      <h2>Inscription</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="email"
          placeholder="Email"
          value={formData.email}
          onChange={(e) => setFormData({...formData, email: e.target.value})}
          required
        />
        <input
          type="password"
          placeholder="Mot de passe"
          value={formData.mot_de_passe}
          onChange={(e) => setFormData({...formData, mot_de_passe: e.target.value})}
          required
        />
        <input
          type="text"
          placeholder="Nom complet"
          value={formData.nom}
          onChange={(e) => setFormData({...formData, nom: e.target.value})}
          required
        />
        <button type="submit">S'inscrire</button>
      </form>
      <p>Déjà un compte? <a href="/login">Se connecter</a></p>
    </div>
  );
};

export default Signup;