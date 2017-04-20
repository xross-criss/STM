package pl.morecraft.dev.stm.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.morecraft.dev.stm.domain.User;
import pl.morecraft.dev.stm.repository.UserRepository;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserResource {

    private final UserRepository userRepository;

    @Autowired
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> getUser(@RequestParam(value = "id") Long id) throws IOException {
        User user = userRepository.findOne(id);
        if (Objects.isNull(user)) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        } else {
            return new ResponseEntity<>(
                    user,
                    HttpStatus.OK
            );
        }
    }

    @RequestMapping(
            value = "",
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> saveUser(@ModelAttribute User user) throws IOException {
        log.debug("Saving User: " + user.toString());
        user = userRepository.save(user);
        return new ResponseEntity<>(
                user,
                HttpStatus.OK
        );
    }

}
