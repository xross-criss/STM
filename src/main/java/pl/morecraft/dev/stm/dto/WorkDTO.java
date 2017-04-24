package pl.morecraft.dev.stm.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WorkDTO extends PriviligeObjectDTO {

    private String name;
    private String subject;
    private String description;
    private String status;

}
