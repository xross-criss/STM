package pl.morecraft.dev.stm.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.morecraft.dev.stm.domain.User;
import pl.morecraft.dev.stm.dto.UserDTO;
import pl.morecraft.dev.stm.service.UserService;

import java.io.IOException;


@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> getUser(@RequestParam(value = "id") Long id) throws IOException {
        return new ResponseEntity<>(
                userService.getUser(id),
                HttpStatus.OK
        );
    }

    @RequestMapping(
            value = "",
            method = {RequestMethod.POST, RequestMethod.PUT},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> saveUser(@ModelAttribute UserDTO user) throws IOException {
        return new ResponseEntity<>(
                userService.saveUser(user),
                HttpStatus.OK
        );
    }
}
