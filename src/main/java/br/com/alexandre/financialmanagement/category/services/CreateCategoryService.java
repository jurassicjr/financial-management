package br.com.alexandre.financialmanagement.category.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.alexandre.financialmanagement.category.dtos.CategoryDTO;
import br.com.alexandre.financialmanagement.category.entities.Category;
import br.com.alexandre.financialmanagement.category.repositories.CategoriesRepository;
import br.com.alexandre.financialmanagement.shared.error.WSException;

@ApplicationScoped
public class CreateCategoryService {

	@Inject
	private CategoriesRepository categoriesRepository;

	public Category createCategory(CategoryDTO categoryDTO) throws WSException {
		if (categoryDTO.getCategoryName().isBlank() || categoryDTO.getCategoryName().isEmpty()) {
			throw new WSException("Please inform a valid category name!");
		}

		Optional<Category> findCategoryByName = categoriesRepository.find("categoryName", categoryDTO.getCategoryName())
				.firstResultOptional();
		if (findCategoryByName.isPresent()) {
			throw new WSException("A category with this name already exists!");
		}

		Category category = Category.builder().id(UUID.randomUUID().toString())
				.categoryName(categoryDTO.getCategoryName()).createdAt(LocalDateTime.now())
				.updatedAt(LocalDateTime.now()).build();

		categoriesRepository.persist(category);

		return category;
	}
}
