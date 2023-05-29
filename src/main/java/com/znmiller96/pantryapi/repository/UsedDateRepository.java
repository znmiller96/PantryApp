package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.dao.UsedDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsedDateRepository
        extends JpaRepository<UsedDate, Integer> {
}
