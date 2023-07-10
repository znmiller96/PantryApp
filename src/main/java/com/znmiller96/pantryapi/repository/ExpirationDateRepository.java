package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.dao.ExpirationDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpirationDateRepository
        extends JpaRepository<ExpirationDate, Integer> {

    //@Query("SELECT u FROM ExpirationDate u WHERE u.id = ?1")
    List<ExpirationDate> findById(int Id);
}
