package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mod_task")
@Getter
@Setter
@NoArgsConstructor
public class Task extends Work {

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id")
    private Project project;

    @JoinColumn(name = "parent")
    private Task parent;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id")
    private User assigned;

}
