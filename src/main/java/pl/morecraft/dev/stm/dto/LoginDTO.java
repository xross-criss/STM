package pl.morecraft.dev.stm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginDTO {

    private String login;
    private String password;

}
