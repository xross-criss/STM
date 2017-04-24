package pl.morecraft.dev.stm.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.morecraft.dev.stm.domain.User;
import pl.morecraft.dev.stm.dto.UserDTO;
import pl.morecraft.dev.stm.exception.ObjectNotFoundException;
import pl.morecraft.dev.stm.repository.UserRepository;

import java.util.Objects;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUser(Long id) {
        User user = userRepository.findOne(id);
        if (Objects.isNull(user)) {
            throw new ObjectNotFoundException("User with id=" + id + " not found");
        }

        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setPassword(null);
        return userDTO;
    }

    public UserDTO saveUser(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);

        log.debug("Saving Task: " + userDTO.toString());

        user = userRepository.save(user);

        return modelMapper.map(user, UserDTO.class);
    }

}

