package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.dao.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository
        extends JpaRepository<Location, Integer> {

    @Query("SELECT u FROM Location u WHERE u.userid = ?1")
    List<Location> findAllByUserid(Integer userid);
}
