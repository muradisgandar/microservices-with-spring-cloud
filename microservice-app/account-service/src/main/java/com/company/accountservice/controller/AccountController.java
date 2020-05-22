package com.company.accountservice.controller;

import com.company.accountservice.service.AccountServiceInter;
import com.company.client.contract.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountServiceInter accountServiceInter;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(accountServiceInter.get(id));
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAll() {
        return ResponseEntity.ok(accountServiceInter.findAll());
    }


    @PostMapping
    public ResponseEntity<AccountDTO> add(@RequestBody AccountDTO account) {
        return ResponseEntity.ok(accountServiceInter.add(account));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> update(@PathVariable("id") String id, @RequestBody AccountDTO account) {
        return ResponseEntity.ok(accountServiceInter.update(id, account));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        accountServiceInter.delete(id);
    }

}
