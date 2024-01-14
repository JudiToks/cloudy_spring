package com.example.cloudy_spring.controller;

import com.example.cloudy_spring.models.Annonce;
import com.example.cloudy_spring.models.Marque;
import com.example.cloudy_spring.repository.AnnonceRepository;
import com.example.cloudy_spring.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")
public class AnnonceController
{
    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceController(AnnonceRepository annonceRepository)
    {
        this.annonceRepository = annonceRepository;
    }

    @GetMapping("/findAll")
    public List<Annonce> findAll()
    {
        return (List<Annonce>) annonceRepository.findAll();
    }

    @GetMapping("/findById/{id_annonce}")
    public Annonce findById(@PathVariable int id_annonce)
    {
        return annonceRepository.findById(id_annonce);
    }

//    @PostMapping("/save/{nom}")
//    public Annonce save(@PathVariable String nom)
//    {
//        Annonce annonce = new Annonce(0, );
//        return annonceRepository.save(annonce);
//    }

    @PostMapping("/delete/{id_annonce}")
    public void deleteById(@PathVariable int id_annonce)
    {
        annonceRepository.deleteById(id_annonce);
    }
}
