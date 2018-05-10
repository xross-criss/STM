package pl.morecraft.dev.bdb.dao;

import org.apache.ibatis.annotations.*;
import pl.morecraft.dev.bdb.domain.Book;

import java.util.List;

@Mapper
public interface BookDAO extends AuthorDAO, CategoryDAO {

    @Select("select * from book")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "author", column = "author", one = @One(select = "getAuthor")),
            @Result(property = "category", column = "category", one = @One(select = "getCategory")),
            @Result(property = "status", column = "status")
    })
    List<Book> getAllBooks();

    @Select("select * from book where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "author", column = "author", one = @One(select = "getAuthor")),
            @Result(property = "category", column = "category", one = @One(select = "getCategory")),
            @Result(property = "status", column = "status")
    })
    Book getBook(Integer id);

/*    @Insert("INSERT INTO book " +
            "            (title, author, category, status)" +
            "     VALUES (#{book.title}, #{book.author}, #{book.category}, #{book.status})")
    @Options(useGeneratedKeys = true, keyProperty = "book.id", keyColumn = "id")
    int createBook(@Param("book") Book category);

    @Update("UPDATE book" +
            "   SET title = COALESCE(#{book.title}), " +
            "       author = COALESCE(#{book.author}), " +
            "       category = COALESCE(#{book.category}), " +
            "       status = COALESCE(#{book.status}) " +
            " WHERE id = #{book.id}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    void updateBook(@Param("book") Book category);*/

}
