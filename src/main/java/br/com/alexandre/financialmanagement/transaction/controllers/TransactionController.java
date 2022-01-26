package br.com.alexandre.financialmanagement.transaction.controllers;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.alexandre.financialmanagement.shared.error.WSException;
import br.com.alexandre.financialmanagement.transaction.dtos.TransactionCompletionDTO;
import br.com.alexandre.financialmanagement.transaction.dtos.TransactionDTO;
import br.com.alexandre.financialmanagement.transaction.entities.Transaction;
import br.com.alexandre.financialmanagement.transaction.services.CompleteTransactionService;
import br.com.alexandre.financialmanagement.transaction.services.CreateTransactionService;
import br.com.alexandre.financialmanagement.transaction.services.DetailTransactionService;
import br.com.alexandre.financialmanagement.transaction.services.ListTransactionsService;

@Path("/transactions")
public class TransactionController {

	@Inject
	private CreateTransactionService createTransactionService;
	
	@Inject
	private DetailTransactionService detailTransactionService;
	
	@Inject 
	private ListTransactionsService listTransactionsService;
	
	@Inject
	private CompleteTransactionService completeTransactionService;

	@POST
	@Transactional
	public Response createTransaction(TransactionDTO transactionDTO) throws WSException {
		Transaction transaction = createTransactionService.execute(transactionDTO);

		URI uri = UriBuilder.fromUri("/transactions/{id}").build(transaction.getId());

		return Response.created(uri).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getTransaction(@PathParam("id") String id) throws WSException {
		Transaction transaction = detailTransactionService.execute(id);
		return Response.ok(transaction).build();
	}
	
	@GET
	public Response listAllTransactions() {
		List<Transaction> transactions = listTransactionsService.execute();
		
		return Response.ok(transactions).build();
	}
	
	@PUT
	@Path("/{id}")
	@Transactional
	public Response updateTransaction(@PathParam("id") String id, TransactionCompletionDTO transactionCompletionDTO) throws WSException {
		Transaction transaction = completeTransactionService.execute(id, transactionCompletionDTO);
		return Response.ok(transaction).build();
	}

}
