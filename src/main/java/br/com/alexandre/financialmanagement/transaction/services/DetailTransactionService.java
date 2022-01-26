package br.com.alexandre.financialmanagement.transaction.services;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.alexandre.financialmanagement.shared.error.WSException;
import br.com.alexandre.financialmanagement.transaction.entities.Transaction;
import br.com.alexandre.financialmanagement.transaction.repositories.TransactionsRepository;

@ApplicationScoped
public class DetailTransactionService {

	
	@Inject
	private TransactionsRepository transactionsRepository;
	
	
	public Transaction execute(String id) throws WSException {
		Optional<Transaction> findTransactionById = transactionsRepository.findById(id);
		if(findTransactionById.isEmpty()) {
			throw new WSException("Invalid id! no transaction found!");
		}
		
		return findTransactionById.get();
	}
}
