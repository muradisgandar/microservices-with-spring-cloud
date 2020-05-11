package com.company.accountservice.service;

import com.company.accountservice.dao.AccountRepository;
import com.company.accountservice.model.Account;
import com.company.client.contract.AccountDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountServiceInter {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountDTO get(String id) {
        Account account = accountRepository.findById(id).
                orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(account, AccountDTO.class);
    }

    @Transactional
    @Override
    public AccountDTO add(AccountDTO accountDTO) {
        //account.setCreatedAt(new java.sql.Date(new Date().getTime()));
        Account account = modelMapper.map(accountDTO, Account.class);
        //account.setId(UUID.randomUUID().toString());
        account = accountRepository.save(account);
        accountDTO.setId(account.getId());
        return accountDTO;
    }

    @Transactional
    @Override
    public AccountDTO update(String id, AccountDTO accountDTO) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            Account accountToUpdate = account.get();
            if (accountDTO.getBirthDate() != null) {
                accountToUpdate.setBirthDate(accountDTO.getBirthDate());
            }
            if (accountDTO.getName() != null) {
                accountToUpdate.setName(accountDTO.getName());
            }
            if (accountDTO.getSurname() != null) {
                accountToUpdate.setSurname(accountDTO.getSurname());
            }

            return modelMapper.map(accountRepository.save(accountToUpdate), AccountDTO.class);

        } else {
            throw new IllegalArgumentException();
        }

    }

    @Transactional
    @Override
    public void delete(String id) {
        Account account = accountRepository.findById(id).
                orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }

    @Override
    public List<AccountDTO> findAll() {
        return null;
    }

}
