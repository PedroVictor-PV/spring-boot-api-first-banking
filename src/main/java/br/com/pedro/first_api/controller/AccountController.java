package br.com.pedro.first_api.controller;

import org.openapitools.api.AccountApi;
import org.openapitools.model.Account;
import org.openapitools.model.DepositRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController implements AccountApi {

    private final Map<String, Account> accountStore = new HashMap<>();
    @Override
    public ResponseEntity<Void> depositToAccount(
            @Valid DepositRequest depositRequest) {
        Account acc = accountStore.get(depositRequest.getAccountNumber());
        if(acc == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        acc.setBalance(acc.getBalance() + depositRequest.getDepositAmount());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Account>> getAccount(){
        List<Account> allAccounts = new ArrayList<>(accountStore.values());
        return ResponseEntity.ok(allAccounts);

        }
    @Override
    public ResponseEntity<Account> createAccount(Account account){
        if (accountStore.containsKey(account.getAccountNumber())) {
            return ResponseEntity.badRequest().build();
        }

        // Armazena a conta na memória
        accountStore.put(account.getAccountNumber(), account);

        return ResponseEntity.status(201).body(account);
    }

    }

