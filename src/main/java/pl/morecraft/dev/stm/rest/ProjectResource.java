package pl.morecraft.dev.stm.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.stm.dto.ProjectDTO;
import pl.morecraft.dev.stm.service.ProjectService;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/project")
public class ProjectResource {

    private final ProjectService projectService;

    @Autowired
    public ProjectResource(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProjectDTO> getProject(@RequestParam(value = "id") Long id) throws IOException {
            return new ResponseEntity<>(
                    projectService.getProject(id),
                    HttpStatus.OK
            );
        }

    @RequestMapping(
            value = "",
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProjectDTO> saveProject(@ModelAttribute ProjectDTO project) throws IOException {
        return new ResponseEntity<>(
                projectService.saveProject(project),
                HttpStatus.OK
        );
    }

}
