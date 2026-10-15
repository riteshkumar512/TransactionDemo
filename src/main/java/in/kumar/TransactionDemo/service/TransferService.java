package in.kumar.TransactionDemo.service;

import in.kumar.TransactionDemo.model.Account;
import in.kumar.TransactionDemo.model.TransferRecord;
import in.kumar.TransactionDemo.repository.AccountRepository;
import in.kumar.TransactionDemo.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    private final TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository,
                           TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void transfer(Long fromAccountId ,
                         Long toAccountId ,
                         BigDecimal amount){

        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(()-> new RuntimeException("User not found"));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(()-> new RuntimeException("User not found"));

        fromAccount.debitAccount(amount);
        toAccount.creditAccout(amount);
        transferRepository.save(new TransferRecord(
                fromAccountId,
                toAccountId,
                amount,
                LocalDate.now()
        ));

    }
}
