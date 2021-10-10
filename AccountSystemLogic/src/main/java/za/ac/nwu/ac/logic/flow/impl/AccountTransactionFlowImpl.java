package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.AccountTransactionFlow;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class AccountTransactionFlowImpl implements AccountTransactionFlow {

    AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public AccountTransactionFlowImpl(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public List<AccountTransactionDto> findAllTransactionsForAccountId(Long accountId) {
        return accountTransactionRepository.findAllByAccountType_AccountTypeID(accountId).stream().map(AccountTransactionDto::new).collect(Collectors.toList());
    }

    @Override
    public AccountTransactionDto findByTxnId(Long transactionId) {
        return accountTransactionRepository.findById(transactionId).map(AccountTransactionDto::new).orElseThrow(() -> new RuntimeException("No txn found for id " + transactionId));
    }

    @Override
    public AccountTransactionDto createTransactionForAccount(AccountTransactionDto accountTransactionDto) {
        AccountTransaction accountTransaction = new AccountTransaction();
        AccountType accountType = new AccountType();
        accountType.setAccountTypeID(accountTransactionDto.getAccountId());
        accountTransaction.setAccountType(accountType);
        accountTransaction.setTransactionDate(Instant.now());
        accountTransaction.setAmount(accountTransactionDto.getAmount());
        accountTransaction.setDescription(accountTransactionDto.getDescription());
        return new AccountTransactionDto(accountTransactionRepository.saveAndFlush(accountTransaction));
    }

    @Override
    public void deleteTransactionById(Long txnId) {
        accountTransactionRepository.deleteById(txnId);
    }
}
