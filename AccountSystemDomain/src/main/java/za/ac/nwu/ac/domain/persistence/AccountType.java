package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "ACCOUNT_TYPE", schema = "hr")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 3833725316797154577L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ACCOUNT_ID")
    private Long accountTypeID;
    @Column(name = "MNEMONIC")
    private String mnemonic;
    @Column(name = "ACCOUNT_TYPE")
    private String accountTypeName;
    @Column(name = "ACCOUNT_CREATION_DATE")
    private Instant creationDate;

    @Column(name = "ACCOUNT_CURRENCY")
    private String accountCurrency;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "accountType", orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<AccountTransaction> accountTransactions;


    public AccountType(long accountTypeID, String mnemonic, String accountTypeName, Instant creationDate, Member member, String accountCurrency) {
        this.accountTypeID = accountTypeID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
        this.member = member;
        this.accountCurrency = accountCurrency;
    }

    public AccountType() {

    }


    public long getAccountTypeID() {
        return accountTypeID;
    }


    public String getMnemonic() {
        return mnemonic;
    }


    public String getAccountTypeName() {
        return accountTypeName;
    }


    public Instant getCreationDate() {
        return creationDate;
    }


    public List<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }


    public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }


    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }


    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate) && Objects.equals(accountCurrency, that.accountCurrency) && Objects.equals(member, that.member) && Objects.equals(accountTransactions, that.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, mnemonic, accountTypeName, creationDate, accountCurrency, member, accountTransactions);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeID=" + accountTypeID +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                ", accountCurrency='" + accountCurrency + '\'' +
                ", member=" + member +
                '}';
    }
}
