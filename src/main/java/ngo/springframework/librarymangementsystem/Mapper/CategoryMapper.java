package ngo.springframework.librarymangementsystem.Mapper;

import ngo.springframework.librarymangementsystem.DTOs.CategoryDTO;
import ngo.springframework.librarymangementsystem.model.Category;

public class CategoryMapper {
    public static CategoryDTO CategoryToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
