package in.kumar.TransactionDemo.service;

import in.kumar.TransactionDemo.model.Account;
import in.kumar.TransactionDemo.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createUser(Account account){
        accountRepository.save(account);
    }
}
