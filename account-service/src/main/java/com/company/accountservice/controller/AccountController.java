package com.company.accountservice.controller;

import com.company.accountservice.entity.Account;
import com.company.accountservice.service.AccountServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("account")
/**
 * localhost:8080/account
 *
 */
public class AccountController {

    private final AccountServiceInter accountServiceInter;

    public AccountController(AccountServiceInter accountServiceInter){
        this.accountServiceInter = accountServiceInter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountServiceInter.get(id));
    }


    @PostMapping
    public ResponseEntity<Account> add(@RequestBody Account account) {
        return ResponseEntity.ok(accountServiceInter.add(account));
    }

    @PutMapping
    public ResponseEntity<Account> update(Account account) {
        return ResponseEntity.ok(accountServiceInter.update(account));
    }

    @DeleteMapping
    public void delete(String id) {
        accountServiceInter.delete(id);
    }

}
