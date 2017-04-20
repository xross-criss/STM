package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mod_project")
@Getter
@Setter
@NoArgsConstructor
public class Project extends Work {

    @OneToOne
    @JoinColumn(name = "parent")
    private Project parent;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner")
    private User owner;

    @ManyToMany
    @JoinTable(name = "mod_project_user",
            joinColumns = {@JoinColumn(name = "mod_project_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "prv_user_id", referencedColumnName = "id")})
    private List<User> users;

}
