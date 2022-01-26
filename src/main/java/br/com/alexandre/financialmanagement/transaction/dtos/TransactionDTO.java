package br.com.alexandre.financialmanagement.transaction.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.alexandre.financialmanagement.transaction.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

	private TransactionType transactionType;
	
	private String categoryId;
	
	private Double predictedValue;
	
	private boolean accomplished = false;
	
	private String origin;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate deadLine;
}
