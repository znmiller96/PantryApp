package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.dao.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PantryRepository
        extends JpaRepository<Pantry, Integer> {

    //TODO get pantry item by userId

    //TODO get pantry items by quantity level

    //TODO get pantry items by expiration date
}
