package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.dao.ExpirationDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpirationDateRepository
        extends JpaRepository<ExpirationDate, String> {
}
