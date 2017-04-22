package pl.morecraft.dev.stm.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.stm.domain.Task;
import pl.morecraft.dev.stm.repository.TaskRepository;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/task")
public class TaskResource {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskResource(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<Task> getTask(@RequestParam(value = "id") Long id) throws IOException {
        Task task = taskRepository.findOne(id);
        if (Objects.isNull(task)) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        } else {
            return new ResponseEntity<>(
                    task,
                    HttpStatus.OK
            );
        }
    }

    @RequestMapping(
            value = "",
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<Task> saveTask(@ModelAttribute Task task) throws IOException {
        log.debug("Saving Task: " + task.toString());
        task = taskRepository.save(task);
        return new ResponseEntity<>(
                task,
                HttpStatus.OK
        );
    }
}
