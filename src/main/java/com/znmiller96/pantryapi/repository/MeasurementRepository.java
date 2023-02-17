package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository
        extends JpaRepository<Measurement, Integer> {
}
