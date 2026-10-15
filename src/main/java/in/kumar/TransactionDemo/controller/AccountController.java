package in.kumar.TransactionDemo.controller;

import in.kumar.TransactionDemo.model.Account;
import in.kumar.TransactionDemo.service.AccountService;
import in.kumar.TransactionDemo.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<String> createAccount(
            @RequestBody Account account
            ){
        accountService.createUser(account);
        return ResponseEntity.ok("Account Created Successfully.");
    }


}
