package pl.morecraft.dev.bdb.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.morecraft.dev.bdb.domain.dictionary.BookStatus;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book implements Serializable {

    private Integer id;

    private String title;
    private Author author;
    private Category category;
    private BookStatus status;

}
