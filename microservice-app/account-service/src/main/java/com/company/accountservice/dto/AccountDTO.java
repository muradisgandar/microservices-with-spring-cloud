package com.company.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private String id;
    private String username;
    private String name;
    private String surname;
    private Date birthDate;
    private String email;
}
