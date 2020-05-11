package com.company.accountservice.service;

import com.company.client.contract.AccountDTO;

import java.util.List;

public interface AccountServiceInter {

    AccountDTO get(String id);

    AccountDTO add(AccountDTO account);

    AccountDTO update(String id, AccountDTO account);

    void delete(String id);

    List<AccountDTO> findAll();

}
