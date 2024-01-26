package com.example.cloudy_spring.repository;

import com.example.cloudy_spring.models.Annonce;
import org.springframework.data.repository.CrudRepository;

public interface AnnonceRepository extends CrudRepository<Annonce, Integer>
{
    Annonce findById(int id_annonce);
}
