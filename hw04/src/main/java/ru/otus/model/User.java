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
@Table("users")
public class User {
    @Id
    @Column("id")
    Long id;
    @Column("username")
    String username;
    @Column("first_name")
    String firstName;
    @Column("last_name")
    String lastName;
    @Column("email")
    String email;
    @Column("phone")
    String phone;
}
