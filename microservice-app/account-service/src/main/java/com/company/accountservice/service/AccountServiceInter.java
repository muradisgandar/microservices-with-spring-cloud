package com.company.accountservice.service;

import com.company.accountservice.entity.Account;

import java.util.List;

public interface AccountServiceInter {

    Account get(String id);

    Account add(Account account);

    Account update(String id, Account account);

    void delete(String id);

    List<Account> findAll();

}
