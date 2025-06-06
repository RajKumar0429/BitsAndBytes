package com.bitsnbytes.product.service;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.exception.CategoryAlreadyExistException;
import com.bitsnbytes.product.mapper.CategoryMapper;
import com.bitsnbytes.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;
    //create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){

        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExistException("Category " + categoryDTO.getName() +  " already exists!");
        }
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
       category = categoryRepository.save(category);
        System.out.println("Saved Category ID: " + category.getId());
       return CategoryMapper.toCategoryDTO(category);
    }
    //get all categories
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toCategoryDTO).toList();

    }
    //get category By id
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }
    //delete category
//    public String deleteCategory(Long id) {
//        categoryRepository.deleteById(id);
//        return "category " + id + " has been deleted";
//    }

    public String deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category with ID " + id + " not found!");
        }
        categoryRepository.deleteById(id);
        return "Category " + id + " has been deleted!";
    }

}
