package pl.morecraft.dev.bdb.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Category implements Serializable {

    private Integer id;

    private String code;
    private String name;
    private String description;

}
