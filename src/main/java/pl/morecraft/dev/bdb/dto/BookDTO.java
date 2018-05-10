package pl.morecraft.dev.bdb.dto;

import lombok.*;
import pl.morecraft.dev.bdb.domain.Author;
import pl.morecraft.dev.bdb.domain.Category;
import pl.morecraft.dev.bdb.domain.dictionary.BookStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {

    private Integer id;

    private String title;
    private Author author;
    private Category category;
    private BookStatus status;

}
