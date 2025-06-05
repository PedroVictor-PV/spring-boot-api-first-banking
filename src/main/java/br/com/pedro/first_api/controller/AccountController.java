package br.com.pedro.first_api.controller;

import org.openapitools.api.AccountApi;
import org.openapitools.model.Account;
import org.openapitools.model.DepositRequest;
import org.openapitools.model.WithdrawRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController implements AccountApi {

    // forma de salvar as alterações em memória
    private final Map<String, Account> accountStore = new HashMap<>();

    @Override
    public ResponseEntity<String> depositToAccount(
            @Valid DepositRequest depositRequest) {
        //tenta encontrar a conta a partir do number account
        Account acc = accountStore.get(depositRequest.getAccountNumber());
        if (acc == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("conta nao encontrada");
        }
        //altera os dados e adiciona o saldo
        acc.setBalance(acc.getBalance() + depositRequest.getDepositAmount());
        return ResponseEntity.ok("deposito realizado");
    }

    @Override
    public ResponseEntity<List<Account>> getAccount() {
        List<Account> allAccounts = new ArrayList<>(accountStore.values());
        return ResponseEntity.ok(allAccounts);

    }

    @Override
    public ResponseEntity<?> createAccount(Account account) {
        //busca se ja existe a conta
        if (accountStore.containsKey(account.getAccountNumber())) {
            return ResponseEntity.badRequest().body("informaçoes invalidas");

        }

        accountStore.put(account.getAccountNumber(), account);
        return ResponseEntity.status(201).body(account);
    }

    @Override
    public ResponseEntity<String> deleteAccount(String accountNumber) {
        //devolver erro not found
        Account acc = accountStore.get(accountNumber);
        if (acc == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta não encontrada.");
        }
        accountStore.remove(accountNumber);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<String> withdrawToAccount(
            @Valid WithdrawRequest withdrawRequest) {
        Account acc = accountStore.get(withdrawRequest.getAccountNumber());
        if (acc == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta não encontrada.");
        }

        if (withdrawRequest.getWithdrawAmount() > acc.getBalance()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insuficiente.");
        }

        acc.setBalance(acc.getBalance() - withdrawRequest.getWithdrawAmount());
        return ResponseEntity.ok("Saque realizado com sucesso");
    }
}

