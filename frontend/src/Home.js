import React from 'react';
import { useLocation } from 'react-router-dom';

const Home = () => {
  const location = useLocation();
  const user = location.state?.user || { nom: 'Utilisateur' };

  return (
    <div className="home-container">
      <h1>Bienvenue, {user.nom}!</h1>
      <p>Vous êtes maintenant connecté.</p>
    </div>
  );
};

export default Home;