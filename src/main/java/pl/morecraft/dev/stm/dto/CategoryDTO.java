package pl.morecraft.dev.stm.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {

    private Long id;
    private String code;
    private String description;

}
