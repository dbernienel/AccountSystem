package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.AccountTypeRespository;
import za.ac.nwu.ac.repo.persistence.MemberRespository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRespository accountTypeRespository;
    private final MemberRespository memberRespository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRespository accountTypeRespository, MemberRespository memberRespository) {
        this.accountTypeRespository = accountTypeRespository;
        this.memberRespository = memberRespository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRespository.findAll()) {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e) {
            //TODO: Log
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        try {
            AccountType accountType = accountTypeRespository.getAccountTypeByMnemonicNativeQuery(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        try {
            AccountType accountType = accountTypeRespository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        AccountType accountType = accountTypeRespository.save(fromDto(accountTypeDto));
        return new AccountTypeDto(accountType);
    }

    AccountType fromDto(final AccountTypeDto accountTypeDto) {
        if (accountTypeDto != null) {
            Optional<Member> member = memberRespository.findOneById(accountTypeDto.getMemberId());
            RuntimeException runtimeException = new RuntimeException("Unable to find Member for id " + accountTypeDto.getId());
            return member
                    .map(m -> new AccountType(accountTypeDto.getId(), accountTypeDto.getMnemonic(), accountTypeDto.getAccountTypeName(), Instant.now(), m, accountTypeDto.getCurrency()))
                    .orElseThrow(() -> runtimeException);
        }
        return null;
    }

}
