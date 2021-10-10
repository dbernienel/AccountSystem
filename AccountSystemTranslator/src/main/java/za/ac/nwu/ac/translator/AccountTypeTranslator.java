package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto create(AccountTypeDto accountType);
}
