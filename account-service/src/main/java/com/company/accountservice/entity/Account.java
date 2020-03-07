package com.company.accountservice.entity;

import lombok.Data;

@Data
public class Account {

    private String id;
    private String username;
    private String email;
    private String passwd;
}
