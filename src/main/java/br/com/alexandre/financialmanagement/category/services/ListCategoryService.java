package br.com.alexandre.financialmanagement.category.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.alexandre.financialmanagement.category.entities.Category;
import br.com.alexandre.financialmanagement.category.repositories.CategoriesRepository;

@ApplicationScoped
public class ListCategoryService {
	
	@Inject
	private CategoriesRepository categoriesRepository;

	public List<Category> list() {
		return categoriesRepository.findAll().list();
	}

	
	
}
