package com.company.accountservice.model;

import com.datastax.driver.core.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "accounts")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Column(value = "uname")
    private String username;

    @Column(value = "name")
    private String name;

    @Column(value = "surname")
    private String surname;

    @Column(value = "birth_date")
    private Date birthDate;

    @Column(value = "email")
    private String email;

    @Column(value = "pwd")
    private String password;

    @Column(value = "created_at")
    private Date createdAt;

    @Column(value = "is_active")
    private Boolean active;

}
