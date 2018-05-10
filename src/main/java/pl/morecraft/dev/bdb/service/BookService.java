package pl.morecraft.dev.bdb.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.morecraft.dev.bdb.domain.Author;
import pl.morecraft.dev.bdb.domain.Book;
import pl.morecraft.dev.bdb.dto.AuthorDTO;
import pl.morecraft.dev.bdb.dto.BookDTO;
import pl.morecraft.dev.bdb.exception.ObjectNotFoundException;
import pl.morecraft.dev.bdb.repository.AuthorRepository;
import pl.morecraft.dev.bdb.repository.BookRepository;

import java.util.Objects;

@Slf4j
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDTO getBook(Integer id) {
        Book book = bookRepository.findOne(id);
        if (Objects.isNull(book)) {
            throw new ObjectNotFoundException("Book with id=" + id + " not found");
        }

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(book, BookDTO.class);
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Book book = modelMapper.map(bookDTO, Book.class);

        log.debug("Saving Book: " + bookDTO.toString());

        book = bookRepository.save(book);

        return modelMapper.map(book, BookDTO.class);
    }
}
