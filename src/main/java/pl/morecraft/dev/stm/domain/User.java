package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.morecraft.dev.stm.domain.dictionary.UserStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "prv_user")
@Getter
@Setter
@NoArgsConstructor
public class User extends PrivilegeObject {

    private String first_name;
    private String second_name;
    private String last_name;
    private String title;
    private String email;
    private int phone;
    private String password;
    private String password_expiration_date;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
