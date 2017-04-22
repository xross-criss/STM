package pl.morecraft.dev.stm.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.stm.domain.Project;
import pl.morecraft.dev.stm.repository.ProjectRepository;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/project")
public class ProjectResource {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectResource(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<Project> getProject(@RequestParam(value = "id") Long id) throws IOException {
        Project project = projectRepository.findOne(id);
        if (Objects.isNull(project)) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        } else {
            return new ResponseEntity<Project>(
                    project,
                    HttpStatus.OK
            );
        }
    }

    @RequestMapping(
            value = "",
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Project> saveProject(@ModelAttribute Project project) throws IOException {
        log.debug("Saving Project: " + project.toString());
        project = projectRepository.save(project);
        return new ResponseEntity<>(
                project,
                HttpStatus.OK
        );
    }
}
