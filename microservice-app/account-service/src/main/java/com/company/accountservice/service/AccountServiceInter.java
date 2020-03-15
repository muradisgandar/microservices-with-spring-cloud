package com.company.accountservice.service;

import com.company.accountservice.entity.Account;
import java.util.List;

public interface AccountServiceInter {

    public Account get(String id);

    public Account add(Account account);

    public Account update(String id, Account account);

    public void delete(String id);

    public List<Account> findAll();

}
