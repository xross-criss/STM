package pl.morecraft.dev.bdb.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.morecraft.dev.bdb.domain.Author;
import pl.morecraft.dev.bdb.dto.AuthorDTO;
import pl.morecraft.dev.bdb.exception.ObjectNotFoundException;
import pl.morecraft.dev.bdb.repository.AuthorRepository;

import java.util.Objects;

@Slf4j
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO getAuthor(Integer id) {
        Author author = authorRepository.findOne(id);
        if (Objects.isNull(author)) {
            throw new ObjectNotFoundException("Autor with id=" + id + " not found");
        }

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(author, AuthorDTO.class);
    }

    public AuthorDTO saveAuthor(AuthorDTO authorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Author author = modelMapper.map(authorDTO, Author.class);

        log.debug("Saving Author: " + authorDTO.toString());

        author = authorRepository.save(author);

        return modelMapper.map(author, AuthorDTO.class);
    }
}
