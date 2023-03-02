package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.Catrgory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository
        extends JpaRepository<Catrgory, Integer> {

    @Query("SELECT u FROM Catrgory u WHERE u.userid = ?1")
    List<Catrgory> findAllByUserid(Integer userid);
}
