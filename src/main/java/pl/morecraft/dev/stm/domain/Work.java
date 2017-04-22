package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.morecraft.dev.stm.domain.dictionary.WorkStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mod_work")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class Work extends PrivilegeObject {

    private String name;
    private String subject;
    private String description;

    @Enumerated(EnumType.STRING)
    private WorkStatus status;


    @ManyToMany
    @JoinTable(name = "mod_work_category",
            joinColumns = {@JoinColumn(name = "mod_work_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "mod_category_id", referencedColumnName = "id")})
    private List<Category> categories;
}
