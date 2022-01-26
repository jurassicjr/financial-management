package br.com.alexandre.financialmanagement.transaction.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.alexandre.financialmanagement.category.entities.Category;
import br.com.alexandre.financialmanagement.transaction.dtos.TransactionDTO;
import br.com.alexandre.financialmanagement.transaction.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

	@Id
	private String id;

	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_type")
	private TransactionType transactionType;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@Column(name = "predicted_value")
	private Double predictedValue;

	@Column(name = "real_value")
	private Double realValue;

	@Column
	private boolean accomplished;

	@Column(name = "dead_line")
	private LocalDate deadLine;

	private String origin;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public static Transaction parse(TransactionDTO transactionDTO, Category category) {
		return new Transaction(UUID.randomUUID().toString(), transactionDTO.getTransactionType(), category,
				transactionDTO.getPredictedValue(), null, transactionDTO.isAccomplished(), transactionDTO.getDeadLine(),
				transactionDTO.getOrigin(), LocalDateTime.now(), LocalDateTime.now());
	}
}
