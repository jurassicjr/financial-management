package br.com.alexandre.financialmanagement.category.services;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.alexandre.financialmanagement.category.entities.Category;
import br.com.alexandre.financialmanagement.category.repositories.CategoriesRepository;
import br.com.alexandre.financialmanagement.shared.error.WSException;

@ApplicationScoped
public class DetailCategoryService {

	@Inject
	private CategoriesRepository categoriesRepository;
	
	public Category detailCategoryById(String id) throws WSException{
		Optional<Category> findById = categoriesRepository.findById(id);
		if(findById.isEmpty()) {
			throw new WSException("Invalid id! no category found!");
		}
		
		return findById.get();
	}
}
