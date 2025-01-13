package com.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.CategoryModel;

public interface CategoryRepo extends JpaRepository<CategoryModel, Long> {

}
