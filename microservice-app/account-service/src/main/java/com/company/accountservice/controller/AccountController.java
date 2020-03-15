package com.company.accountservice.controller;

import com.company.accountservice.entity.Account;
import com.company.accountservice.service.AccountServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
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

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountServiceInter.findAll());
    }


    @PostMapping
    public ResponseEntity<Account> add(@RequestBody Account account) {
        return ResponseEntity.ok(accountServiceInter.add(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable("id") String id,@RequestBody Account account) {
        return ResponseEntity.ok(accountServiceInter.update(id,account));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        accountServiceInter.delete(id);
    }

}
