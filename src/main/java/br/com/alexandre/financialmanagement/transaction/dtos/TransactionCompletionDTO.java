package br.com.alexandre.financialmanagement.transaction.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is a DTO representing a completion transaction.
 * @author Alexandre Marinho de Souza Júnior.
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCompletionDTO {

	private Double realValue;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate completionDate;
}
