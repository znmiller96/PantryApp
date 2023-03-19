package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.ExpirationDate;
import com.znmiller96.pantryapi.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpirationDateRepository
        extends JpaRepository<ExpirationDate, Integer> {

    @Query("SELECT u FROM ExpirationDate u WHERE u.id = ?1")
    List<ExpirationDate> findAllById(Integer Id);
}
