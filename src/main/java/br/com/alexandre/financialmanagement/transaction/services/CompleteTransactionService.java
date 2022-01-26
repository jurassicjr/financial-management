package br.com.alexandre.financialmanagement.transaction.services;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.TransactionScoped;

import br.com.alexandre.financialmanagement.shared.error.WSException;
import br.com.alexandre.financialmanagement.transaction.dtos.TransactionCompletionDTO;
import br.com.alexandre.financialmanagement.transaction.entities.Transaction;
import br.com.alexandre.financialmanagement.transaction.repositories.TransactionsRepository;

/**
 * This class manage the service related to the update of a transaction.
 * @author Alexandre Marinho de Souza Júnior
 *
 */
@TransactionScoped
public class CompleteTransactionService {

	@Inject
	private TransactionsRepository transactionsRepository;

	/**
	 * Perfom the update of a transaction setting it as complete
	 * @param id - String, the transaction id that will be completed.
	 * @param transactionCompletionDTO - TransactionCompletoinDTO, the DTO that contains all the infromations to finish a transaction.
	 * @return Transaction - The updated transaction
	 * @throws WSException - Execption that might occurs if something wrong happens!
	 */
	public Transaction execute(String id, TransactionCompletionDTO transactionCompletionDTO) throws WSException {
		Optional<Transaction> findTransactionById = transactionsRepository.findById(id);
		
		if(findTransactionById.isEmpty()) {
			throw new WSException("The informed id is not a valid one! please insert another one and try again!");
		}
		
		Transaction transaction = findTransactionById.get();
		
		transaction.setRealValue(transactionCompletionDTO.getRealValue());
		transaction.setDeadLine(transactionCompletionDTO.getCompletionDate());
		transaction.setAccomplished(true);
		transactionsRepository.persist(transaction);
		
		return transaction;
	}
}
