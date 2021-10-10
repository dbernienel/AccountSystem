package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.util.List;

public interface AccountTransactionFlow {
    List<AccountTransactionDto> findAllTransactionsForAccountId(Long accountId);

    AccountTransactionDto findByTxnId(Long transactionId);

    AccountTransactionDto createTransactionForAccount(AccountTransactionDto accountTransaction);

    void deleteTransactionById(Long txnId);
}
