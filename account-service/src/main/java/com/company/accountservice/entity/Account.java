package com.company.accountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String id;
    private String username;
    private String email;
    private String passwd;

    public Account(String id) {
        this.id = id;
    }
}
