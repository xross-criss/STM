package pl.morecraft.dev.stm.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.stm.dto.TaskDTO;
import pl.morecraft.dev.stm.service.TaskService;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/task")
public class TaskResource {

    private final TaskService taskService;

    @Autowired
    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TaskDTO> getTask(@RequestParam(value = "id") Long id) throws IOException {
        return new ResponseEntity<>(
                taskService.getTask(id),
                HttpStatus.OK
        );
    }

    @RequestMapping(
            value = "",
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<TaskDTO> saveTask(@ModelAttribute TaskDTO task) throws IOException {
        return new ResponseEntity<>(
                taskService.saveTask(task),
                HttpStatus.OK
        );
    }

}
