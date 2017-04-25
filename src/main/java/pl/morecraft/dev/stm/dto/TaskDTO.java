package pl.morecraft.dev.stm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TaskDTO {

    private Long id;
    private Long projectId;
    private Long parent;
    private Long assigned;

}
