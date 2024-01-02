package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.dao.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PantryRepository
        extends JpaRepository<Pantry, Integer> {

    List<Pantry> findByUserId(int userId);

    List<Pantry> findByUserIdAndQuantityLevelEqualsIgnoreCase(int userId, String quantityLevel);

    //The _ is used to annotate use column in ExpirationDate table
    List<Pantry> findByUserIdAndExpirationDate_ExpirationDateBefore(int userId, Date expirationDate);

}
