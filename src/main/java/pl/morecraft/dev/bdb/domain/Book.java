package pl.morecraft.dev.bdb.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.morecraft.dev.bdb.domain.dictionary.BookStatus;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @OneToOne
    @JoinColumn(name = "author")
    private Author author;

    @OneToOne
    @JoinColumn(name = "category")
    private Category category;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

}
