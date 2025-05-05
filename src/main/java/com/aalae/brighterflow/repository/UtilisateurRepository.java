package com.aalae.brighterflow.repository;

import com.aalae.brighterflow.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Interface qui hérite de JpaRepository pour gérer les opérations CRUD sur l'entité User.
 * Spring Data JPA génère automatiquement les implémentations à partir de cette interface.
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);
}
