package pl.morecraft.dev.stm.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.morecraft.dev.stm.domain.Task;
import pl.morecraft.dev.stm.dto.TaskDTO;
import pl.morecraft.dev.stm.exception.ObjectNotFoundException;
import pl.morecraft.dev.stm.repository.TaskRepository;

import java.util.Objects;

@Slf4j
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO getTask(Long id) {
        Task task = taskRepository.findOne(id);
        if (Objects.isNull(task)) {
            throw new ObjectNotFoundException("Task with id=" + id + " not found");
        }

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(task, TaskDTO.class);
    }

    public TaskDTO saveTask(TaskDTO taskDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Task task = modelMapper.map(taskDTO, Task.class);

        log.debug("Saving Task: " + taskDTO.toString());

        task = taskRepository.save(task);

        return modelMapper.map(task, TaskDTO.class);
    }

}

