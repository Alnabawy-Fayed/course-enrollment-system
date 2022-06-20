package com.example.courseenrollmentsystem.dao;

import com.example.courseenrollmentsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(collectionResourceRel = "categories",path = "categories")
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
