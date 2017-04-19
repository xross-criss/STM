package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "mod_project")
@Getter
@Setter
@NoArgsConstructor
public class Project extends Work {

    @JoinColumn(name = "parent")
    private Project parent;

    @JoinColumn(name = "owner")
    private User owner;

    private List<User> project_user;

}
