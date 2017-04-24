package pl.morecraft.dev.stm.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private String lastName;
    private String title;
    private String email;
    private Date passwordExpireDate;
    private String status;
    private String phone;

}
