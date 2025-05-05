package com.aalae.brighterflow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String email;
    @Column(name = "mot_de_passe") // Maps to DB column "mot_de_passe"
    private String motDePasse; // camelCase field name
    private String role;
    private String nom;

    // Constructors
    public Utilisateur() {}

    public Utilisateur(String email, String mot_de_passe, String role, String nom) {
        this.email = email;
        this.motDePasse = mot_de_passe;
        this.role = role;
        this.nom = nom;
    }

    // === Getters ===

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMot_de_passe() {
        return motDePasse;
    }

    public String getRole() {
        return role;
    }

    public String getNom() {
        return nom;
    }

    // === Setters ===

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMot_de_passe(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
