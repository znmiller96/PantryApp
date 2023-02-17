package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.Catrgory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Catrgory, Integer> {
}
