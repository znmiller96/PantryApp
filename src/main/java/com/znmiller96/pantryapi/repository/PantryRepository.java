package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.dao.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PantryRepository
        extends JpaRepository<Pantry, Integer> {

    List<Pantry> findByUserid(int userid);

    //TODO get pantry items by quantity level

    //TODO get pantry items by expiration date
}
