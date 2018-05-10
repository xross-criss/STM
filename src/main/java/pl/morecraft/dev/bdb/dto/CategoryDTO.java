package pl.morecraft.dev.bdb.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {

    private Integer id;

    private String code;
    private String name;
    private String description;

}
