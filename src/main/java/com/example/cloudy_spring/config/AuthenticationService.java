package com.example.cloudy_spring.config;

// import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cloudy_spring.models.AuthenticationRequest;
import com.example.cloudy_spring.models.AuthenticationResponse;
import com.example.cloudy_spring.models.RegisterRequest;
import com.example.cloudy_spring.models.Role;
import com.example.cloudy_spring.models.Utilisateur;
import com.example.cloudy_spring.repository.UtilisateurRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // @Bean
    public AuthenticationResponse register(RegisterRequest request) {
        var user=Utilisateur.builder()
        .nom(request.getNom())
        .prenom(request.getPrenom())
        .email(request.getEmail())
        .mdp(passwordEncoder.encode(request.getMdp()))
        .telephone(request.getTelephone())
        .role(Role.USER)
        .build();
        repository.save(user);
        var jwtToken =jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    // @Bean
    public AuthenticationResponse autenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
           new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
           )
        );
        var user=repository.findByEmail(request.getEmail())
        .orElseThrow();
        var jwtToken =jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    
}
