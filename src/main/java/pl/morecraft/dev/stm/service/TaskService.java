package pl.morecraft.dev.stm.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.morecraft.dev.stm.domain.Project;
import pl.morecraft.dev.stm.domain.Task;
import pl.morecraft.dev.stm.dto.TaskDTO;
import pl.morecraft.dev.stm.exception.ObjectNotFoundException;
import pl.morecraft.dev.stm.repository.ProjectRepository;
import pl.morecraft.dev.stm.repository.TaskRepository;

import java.util.Objects;

@Slf4j
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
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

        if(taskDTO.getProject_id() == null){
            throw new ObjectNotFoundException("For Task with id=" + taskDTO.getId()+", cannot be inserted null value as Project Id");
        } else {
            Project project = projectRepository.findOne(taskDTO.getProject_id());
            if(){ //TODO - if statement to check
                throw new ObjectNotFoundException("Cannot find proper project with id=" + taskDTO.getProject_id()+", for Task with id=" + taskDTO.getId());
            }
        }

        log.debug("Saving Task: " + taskDTO.toString());
        task = taskRepository.save(task);

        return modelMapper.map(task, TaskDTO.class);
    }

}

