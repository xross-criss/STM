package pl.morecraft.dev.bdb.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuthorDTO {

    private Integer id;

    private String firstName;
    private String lastName;

}
