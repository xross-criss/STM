package pl.morecraft.dev.bdb.dao;

import org.apache.ibatis.annotations.*;
import pl.morecraft.dev.bdb.domain.Category;

import java.util.List;

@Mapper
public interface CategoryDAO {

    @Select("select * from category")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "code", column = "code"),
            @Result(property = "name", column = "lastname"),
            @Result(property = "description", column = "description")
    })
    List<Category> getAllCategories();

    @Select("select * from category where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "code", column = "code"),
            @Result(property = "name", column = "lastname"),
            @Result(property = "description", column = "description")
    })
    Category getCategory(Integer id);

/*    @Insert("INSERT INTO category " +
            "            (code, name, description)" +
            "     VALUES (#{category.code}, #{category.name}, #{category.description})")
    @Options(useGeneratedKeys = true, keyProperty = "category.id", keyColumn = "id")
    int createCategory(@Param("author") Category category);

    @Update("UPDATE category" +
            "   SET code = COALESCE(#{category.code}), " +
            "       name = COALESCE(#{category.name}), " +
            "       description = COALESCE(#{category.description}) " +
            " WHERE id = #{category.id}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    void updateCategory(@Param("category") Category category);*/

}
