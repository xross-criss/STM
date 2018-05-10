package pl.morecraft.dev.bdb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.morecraft.dev.bdb.dao.AuthorDAO;
import pl.morecraft.dev.bdb.domain.Author;

import java.util.List;

@Slf4j
@Service
public class AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Autowired
    public AuthorService(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public Author getAuthor(Integer authorId) {
        return authorDAO.getAuthor(authorId);
    }

    public List<Author> getAuthorList() {
        return authorDAO.getAllAuthors();
    }
}
