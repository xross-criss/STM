package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.morecraft.dev.stm.domain.dictionary.WorkStatus;

import javax.persistence.*;

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

}
