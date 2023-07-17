package com.znmiller96.pantryapi.repository;

import com.znmiller96.pantryapi.model.dao.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository
        extends JpaRepository<Category, Integer> {

    List<Category> findByUserId(Integer userId);
}
