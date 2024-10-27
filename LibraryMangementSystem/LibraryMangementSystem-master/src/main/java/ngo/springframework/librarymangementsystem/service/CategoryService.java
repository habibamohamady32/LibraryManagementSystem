package ngo.springframework.librarymangementsystem.service;

import ngo.springframework.librarymangementsystem.DTOs.CategoryDTO;
import ngo.springframework.librarymangementsystem.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category createCategory(Category category);
    Optional<CategoryDTO> getCategoryById(Long id); // Ensure the naming is consistent
    List<CategoryDTO> getAllCategories();
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}