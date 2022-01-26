package br.com.alexandre.financialmanagement.category.repositories;

import java.util.Optional;

import javax.inject.Singleton;

import br.com.alexandre.financialmanagement.category.entities.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Singleton
public class CategoriesRepository implements PanacheRepository<Category> {
	
	public Optional<Category> findById(String id) {
		return find("id", id).firstResultOptional();
	}

}
