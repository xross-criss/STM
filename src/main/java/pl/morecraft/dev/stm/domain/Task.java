package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mod_task")
@Getter
@Setter
@NoArgsConstructor
public class Task extends Work {

    @OneToOne
    @JoinColumn(name = "parent")
    private Task parent;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(optional = false)
    @JoinColumn(name = "assigned")
    private User assigned;

}
