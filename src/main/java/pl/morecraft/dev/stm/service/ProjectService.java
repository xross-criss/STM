package pl.morecraft.dev.stm.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.morecraft.dev.stm.domain.Project;
import pl.morecraft.dev.stm.dto.ProjectDTO;
import pl.morecraft.dev.stm.exception.ObjectNotFoundException;
import pl.morecraft.dev.stm.repository.ProjectRepository;

import java.util.Objects;

@Slf4j
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectDTO getProject(Long id) {
        Project project = projectRepository.findOne(id);
        if (Objects.isNull(project)) {
            throw new ObjectNotFoundException("Project with id=" + id + " not found");
        }

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(project, ProjectDTO.class);
    }

    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Project project = modelMapper.map(projectDTO, Project.class);

        log.debug("Saving Task: " + projectDTO.toString());

        project = projectRepository.save(project);

        return modelMapper.map(project, ProjectDTO.class);
    }


}
