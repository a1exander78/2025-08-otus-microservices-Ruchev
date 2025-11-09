package ru.otus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("USERS")
public class User {
    @Id
    @Column("ID")
    Long id;
    @Column("USERNAME")
    String username;
    @Column("FIRST_NAME")
    String firstName;
    @Column("LAST_NAME")
    String lastName;
    @Column("EMAIL")
    String email;
    @Column("PHONE")
    String phone;
}
