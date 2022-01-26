package br.com.alexandre.financialmanagement.transaction.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.alexandre.financialmanagement.transaction.entities.Transaction;
import br.com.alexandre.financialmanagement.transaction.repositories.TransactionsRepository;

@ApplicationScoped
public class ListTransactionsService {

	@Inject
	private TransactionsRepository transactionsRepository;

	public List<Transaction> execute() {
		return transactionsRepository.findAll().stream().sorted((previous, actual) -> {
			if (previous.getDeadLine().isBefore(actual.getDeadLine())) {
				return 1;
			} else
				return 0;
		}).toList();
	}
}
