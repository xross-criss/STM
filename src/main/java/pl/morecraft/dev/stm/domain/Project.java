package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "mod_project")
@Getter
@Setter
@NoArgsConstructor
public class Project extends Work {

    @JoinColumn(name = "parent")
    private Project parent;

//    private List<User> // brakuje ci chyba tabeli zlaczeniowej dla project-user (mod_project_user)

}
