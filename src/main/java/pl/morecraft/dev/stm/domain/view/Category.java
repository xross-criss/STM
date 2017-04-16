package pl.morecraft.dev.stm.domain.view;


import pl.morecraft.dev.stm.domain.dictionaries.proto.DefaultDictionary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mod_category")
public abstract class Category implements DefaultDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotNull
    @Size(min = 3, max = 3)
    @Pattern(regexp = "^[A-Z]*$")
    @Column(unique = true, nullable = false)
    private String code;

    @NotNull
    @Size(min = 3, max = 128)
    private String description;

    public Category(Long id, String code, String description) {
        this.id = id;

        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return code;
    }
}
