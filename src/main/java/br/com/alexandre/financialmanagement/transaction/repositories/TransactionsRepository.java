package br.com.alexandre.financialmanagement.transaction.repositories;

import java.util.Optional;

import javax.inject.Singleton;

import br.com.alexandre.financialmanagement.transaction.entities.Transaction;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Singleton
public class TransactionsRepository implements PanacheRepository<Transaction>{

	public Optional<Transaction> findById(String id) {
		return find("id", id).firstResultOptional();
	}

}
