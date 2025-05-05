package com.aalae.brighterflow.controller;

import com.aalae.brighterflow.model.Utilisateur;
import com.aalae.brighterflow.service.UtilisateurService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UtilisateurService2 service;
    
    @GetMapping("/")
    public String rootRedirect() {
        return "redirect:/login";  // Directly returns login.html template
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String mot_de_passe,
                        Model model) {
        Utilisateur user = service.login(email, mot_de_passe);
        if (user != null) {
            model.addAttribute("username", user.getNom());
            return "home";
        } else {
            model.addAttribute("error", "Email ou mot de passe incorrect !");
            return "login";
        }
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute Utilisateur utilisateur, Model model) {
        try {
            service.save(utilisateur);
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String username, Model model) {
        model.addAttribute("username", username != null ? username : "Utilisateur");
        return "home";
    }
}