package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.morecraft.dev.stm.domain.dictionary.UserStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "prv_user")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class User extends PrivilegeObject {

    private String login;
    private String firstName;
    private String secondName;
    private String lastName;
    private String title;
    private String email;
    private String password;
    private String passwordExpirationDate;
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
