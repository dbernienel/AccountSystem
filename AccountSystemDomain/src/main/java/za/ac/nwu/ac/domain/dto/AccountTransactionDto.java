package za.ac.nwu.ac.domain.dto;

import io.swagger.annotations.ApiModel;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@ApiModel(value = "AccountTransaction",
        description = "A DTO that represents a transaction"
)
public class AccountTransactionDto implements Serializable {

    private Long transactionId;
    private Long accountId;
    private Long memberId;
    private Long amount;
    private Instant transactionDate;
    private String description;

    public AccountTransactionDto(Long transactionId, Long accountId, Long memberId, Long amount, Instant transactionDate, String description) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
    }

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.transactionId = accountTransaction.getTransactionId();
        this.accountId = accountTransaction.getAccountType().getAccountTypeID();
        this.memberId = accountTransaction.getMemberId();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();
        this.description = accountTransaction.getDescription();
        this.transactionDate = accountTransaction.getTransactionDate();
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Instant getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Instant transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountId, that.accountId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountId, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionId=" + transactionId +
                ", accountId=" + accountId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
