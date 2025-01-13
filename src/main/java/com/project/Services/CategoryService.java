package com.project.Services;

import java.util.List;

import com.project.Exception.IdnotFoundException;
import com.project.model.CategoryDTO;
import com.project.model.CategoryModel;

public interface CategoryService {

	public List<CategoryDTO> getAllCategoriesDto(int page, int size);
   public String iscreateCategory(CategoryModel category);
   public CategoryModel isGettingById(long id) throws IdnotFoundException;
   public CategoryModel isUpdatingCategory(long id,CategoryModel ob)throws IdnotFoundException;
   public String isdeletebycategory(long id)throws IdnotFoundException;
    

}

