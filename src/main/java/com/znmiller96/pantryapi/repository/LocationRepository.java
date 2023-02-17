package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository
        extends JpaRepository<Location, Integer> {
}
