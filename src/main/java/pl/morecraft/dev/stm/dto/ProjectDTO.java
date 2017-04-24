package pl.morecraft.dev.stm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProjectDTO {

    private Long id;
    private Long owner;
    private Long parent;

}
