package br.com.alexandre.financialmanagement.transaction.services;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.alexandre.financialmanagement.category.entities.Category;
import br.com.alexandre.financialmanagement.category.repositories.CategoriesRepository;
import br.com.alexandre.financialmanagement.shared.error.WSException;
import br.com.alexandre.financialmanagement.transaction.dtos.TransactionDTO;
import br.com.alexandre.financialmanagement.transaction.entities.Transaction;
import br.com.alexandre.financialmanagement.transaction.repositories.TransactionsRepository;

@ApplicationScoped
public class CreateTransactionService {

	@Inject
	private TransactionsRepository transactionsRepository;
	
	@Inject
	private CategoriesRepository categoriesRepository;
	
	public Transaction execute(TransactionDTO transactionDTO) throws WSException {
		String categoryId = transactionDTO.getCategoryId();
		Optional<Category> findCategoryById = categoriesRepository.findById(categoryId);
		if(findCategoryById.isEmpty()) {
			throw new WSException("Please inform a valid category!");
		}
		
		Transaction transaction = Transaction.parse(transactionDTO, findCategoryById.get());
		
		transactionsRepository.persist(transaction);
		
		return transaction;
		
		
	}
}
