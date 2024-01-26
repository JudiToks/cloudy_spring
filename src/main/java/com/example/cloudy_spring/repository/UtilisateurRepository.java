package com.example.cloudy_spring.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cloudy_spring.models.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer>{
    
    Optional<Utilisateur> findByEmail(String email);
    
}
