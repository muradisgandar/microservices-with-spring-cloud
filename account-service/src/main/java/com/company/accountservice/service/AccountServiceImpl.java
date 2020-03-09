package com.company.accountservice.service;

import com.company.accountservice.dao.AccountRepository;
import com.company.accountservice.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountServiceInter {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account get(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Account add(Account account) {
        account.setCreatedAt(new java.sql.Date(new Date().getTime()));
        return accountRepository.save(account);
    }

    @Override
    public Account update(String id, Account account) {
        Account acc = accountRepository.findById(id).get();
        if(account.getEmail()!=null && !account.getEmail().isEmpty()){
            acc.setEmail(account.getEmail());
        }
        if(account.getUsername() !=null && !account.getUsername().isEmpty()){
            acc.setUsername(account.getUsername());
        }
        if(account.getPassword() !=null && !account.getPassword().isEmpty()){
            acc.setPassword(account.getPassword());
        }
        if(account.getActive()!=null){
            acc.setActive(account.getActive());
        }

        return accountRepository.save(acc);
    }

    @Override
    public void delete(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

}
