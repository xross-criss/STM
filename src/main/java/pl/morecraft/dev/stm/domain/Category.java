package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "mod_category")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Category extends PrivilegeObject {

    private String code;
    private String description;

}
