package com.znmiller96.pantryapi.service;

import com.znmiller96.pantryapi.model.dao.Category;
import com.znmiller96.pantryapi.model.dto.CategoryDto;
import com.znmiller96.pantryapi.repository.CategoryRepository;
import com.znmiller96.pantryapi.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component("CategoryService")
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void addCategory(int userId, List<String> categories) {
        categoryRepository.saveAll(
                categories.stream()
                        .map(category -> new Category.Builder()
                                .withUserId(userId)
                                .withCategory(category)
                                .build())
                        .toList());
    }

    public List<CategoryDto> getCategories(int userId) {
        return categoryRepository.findByUserId(userId)
                .stream().map(Utils::categoryDaoToDto)
                .toList();
    }
}
