package com.company.accountservice.service;

import com.company.accountservice.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountServiceInter {


    @Override
    public Account get(String id) {
        return new Account("test-id");
    }


    @Override
    public Account add(Account account) {
        return new Account("test-id");
    }

    @Override
    public Account update(Account account) {
        return new Account("test-id");
    }

    @Override
    public void delete(String id) {

    }

}
