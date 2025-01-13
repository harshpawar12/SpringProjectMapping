package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.IdnotFoundException;
import com.project.Services.CategoryService;
import com.project.model.CategoryDTO;
import com.project.model.CategoryModel;

@RestController
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    /*
     I am Adding the pagination to Getting all the largeSet
     minimize data to the page
     */
    @GetMapping("/api/categories")
    public List<CategoryDTO> getAllCategories(@RequestParam (defaultValue = "0")int page,
                                              @RequestParam(defaultValue = "5") int size) {
        return categoryService.getAllCategoriesDto(page, size);
    }

 
     @PostMapping("/api/categories")
     public String createCategory(@RequestBody CategoryModel category) {
         return categoryService.iscreateCategory(category);
     }
    
    @GetMapping("/api/categories/{id}")
    public CategoryModel isFindbyid(@PathVariable int id) throws IdnotFoundException
    {
    	return categoryService.isGettingById(id);//1
    }
    
    @PutMapping("/api/categories/{id}")
    public CategoryModel isUpdatingCategory(@PathVariable long id,@RequestBody CategoryModel ob) throws IdnotFoundException
    {
    	return categoryService.isUpdatingCategory(id, ob);
    }
    
    @DeleteMapping("/api/categories/{id}")
    public String isdeletedbyid(@PathVariable long id) throws IdnotFoundException
    {
    	return categoryService.isdeletebycategory(id);
    }

    
}
	

