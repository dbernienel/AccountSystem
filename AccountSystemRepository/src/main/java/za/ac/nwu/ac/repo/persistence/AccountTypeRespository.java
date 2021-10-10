package za.ac.nwu.ac.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountTypeRespository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT " +
            "   ACCOUNT_ID," +
            "   ACCOUNT_TYPE," +
            "   ACCOUNT_CREATION_DATE," +
            "   ACCOUNT_CURRENCY," +
            "   MNEMONIC" +
            "   FROM " +
            "   hr.ACCOUNT_TYPE " +
            "   WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);


    AccountType getAccountTypeByMnemonic(String mnemonic);
}
