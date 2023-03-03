package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository
        extends JpaRepository<Category, Integer> {

    @Query("SELECT u FROM Category u WHERE u.userid = ?1")
    List<Category> findAllByUserid(Integer userid);
}
