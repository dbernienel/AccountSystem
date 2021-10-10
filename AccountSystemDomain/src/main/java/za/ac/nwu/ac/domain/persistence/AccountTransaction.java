package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@Entity
@Table(name = "ACCOUNT_TRANSACTION", schema = "hr")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = -1420294317019175746L;
    @Id
    @Column(name = "TX_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long transactionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private AccountType accountType;
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Column(name = "TX_AMOUNT")
    private Long amount;
    @Column(name = "TX_DATE")
    private Instant transactionDate;
    @Column(name = "TX_DESCRIPTION")
    private String description;

    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionId, AccountType accountType, Long memberId, Long amount, Instant transactionDate, String description) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
    }


    public Long getTransactionId() {
        return transactionId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getAmount() {
        return amount;
    }

    public Instant getTransactionDate() {
        return transactionDate;
    }


    public AccountType getAccountType() {
        return accountType;
    }


    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setTransactionDate(Instant transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }


    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
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
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType.getAccountTypeID(), that.accountType.getAccountTypeID()) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType.getAccountTypeID(), memberId, amount, transactionDate, description);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType.getAccountTypeID() +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", description='" + description + '\'' +
                '}';
    }
}
