package com.company.accountservice.service;

import com.company.accountservice.entity.Account;
import org.springframework.http.ResponseEntity;

public interface AccountServiceInter {

    public Account get(String id);

    public Account add(Account account);

    public Account update(Account account);

    public void delete(String id);

}
