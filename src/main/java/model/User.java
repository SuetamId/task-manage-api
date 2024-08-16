package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "user")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "resetPassword")
    private String resetPassword;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "createAt")
    private LocalDateTime createAt;

    @Column(name = "updateAt")
    private LocalDateTime updateAt;
}
