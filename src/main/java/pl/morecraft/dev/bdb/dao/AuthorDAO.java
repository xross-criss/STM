package pl.morecraft.dev.bdb.dao;

import org.apache.ibatis.annotations.*;
import pl.morecraft.dev.bdb.domain.Author;

import java.util.List;

@Mapper
public interface AuthorDAO {

    @Select("select * from author")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstname", column = "firstname"),
            @Result(property = "lastname", column = "lastname")
    })
    List<Author> getAllAuthors();

    @Select("select * from author where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "firstname", column = "firstname"),
            @Result(property = "lastname", column = "lastname")
    })
    Author getAuthor(Integer id);

/*    @Insert("INSERT INTO author " +
            "            (firstname, lastname)" +
            "     VALUES (#{author.firstname}, #{author.lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "author.id", keyColumn = "id")
    int createAuthor(@Param("author") Author author);

    @Update("UPDATE author" +
            "   SET firstname = COALESCE(#{author.firstname}), " +
            "       lastname = COALESCE(#{author.lastname}) " +
            " WHERE id = #{author.id}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    void updateAuthor(@Param("author") Author author);*/
}
