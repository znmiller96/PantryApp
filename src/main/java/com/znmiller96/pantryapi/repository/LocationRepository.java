package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.dao.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository
        extends JpaRepository<Location, String> {

    List<Location> findByUserId(int userId);
}
