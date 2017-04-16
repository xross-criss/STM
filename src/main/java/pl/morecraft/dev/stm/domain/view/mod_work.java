package pl.morecraft.dev.stm.domain.view;

import org.jetbrains.annotations.NotNull;
import pl.morecraft.dev.stm.domain.dictionaries.proto.DefaultDictionary;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mod_work")
public abstract class mod_work implements DefaultDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotNull
    @Size(min = 3, max = 128)
    @Column(unique = true, nullable = true)
    private String name;

    @Size(max = 512)
    private String subject;

    @Size(max = 1024)
    private String description;

    @NotNull
    @Size(min = 3, max = 3)
    @Pattern(regexp = "^[A-Z]*$")
    @Column(unique = true, nullable = false)
    private String status;

    public mod_work() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
