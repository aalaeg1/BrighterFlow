package com.aalae.brighterflow.service;

import com.aalae.brighterflow.model.Utilisateur;
import com.aalae.brighterflow.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService2 {
    @Autowired
    private UtilisateurRepository repo;

    public Utilisateur login(String email, String mot_de_passe) {
        return repo.findByEmailAndMotDePasse(email, mot_de_passe);
    }

    public void save(Utilisateur u) {
        repo.save(u);
    }
}
