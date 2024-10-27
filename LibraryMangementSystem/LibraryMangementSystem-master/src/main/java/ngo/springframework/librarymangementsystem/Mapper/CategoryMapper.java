package ngo.springframework.librarymangementsystem.Mapper;

import ngo.springframework.librarymangementsystem.DTOs.CategoryDTO;
import ngo.springframework.librarymangementsystem.model.Category;
public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    public static Category toEntity(CategoryDTO dto) {
        if (dto == null) {
            return null;
        }
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }
}

