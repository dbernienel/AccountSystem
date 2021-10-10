package za.ac.nwu.ac.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApiModel(value = "AccountType",
        description = "A DTO that represents the AccountType"
)

public class AccountTypeDto implements Serializable {

    private static final long serialVersionUID = -5346853206480289868L;

    private String mnemonic;
    private String accountTypeName;
    private Instant creationDate;
    private String currency;
    private Long id;
    private Long memberId;
    private List<AccountTransactionDto> transactions;

    public AccountTypeDto() {
    }

    public AccountTypeDto(String mnemonic, String accountTypeName, Instant creationDate, Long id, String currency, Long memberId, List<AccountTransactionDto> transactions) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
        this.id = id;
        this.currency = currency;
        this.memberId = memberId;
        this.transactions = transactions;
    }

    public AccountTypeDto(AccountType accountType) {
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
        this.setMnemonic(accountType.getMnemonic());
        this.id = accountType.getAccountTypeID();
        this.currency = accountType.getAccountCurrency();
        this.memberId = accountType.getMember().getId();
        this.transactions = accountType.getAccountTransactions().stream().map(AccountTransactionDto::new).collect(Collectors.toList());
    }

    @ApiModelProperty(position = 1,
            value = "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Name",
            name = "Name",
            notes = "The name of the AccountType",
            dataType = "java.lan.String",
            example = "Miles",
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "This is the date on which the AccountType was created",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = true,
            required = false)
    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public List<AccountTransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<AccountTransactionDto> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate) && Objects.equals(currency, that.currency) && Objects.equals(id, that.id) && Objects.equals(memberId, that.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accountTypeName, creationDate, currency, id, memberId);
    }
}
