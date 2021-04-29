package com.example.links.dao;

import com.example.links.pojo.Link;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface LinkDAO {

    List<Link> getListByParams(@Param("params") Map<String, Object> params);

    void create(Link link);

    @Update("UPDATE links " +
            "SET updated = now(), short_link = #{shortLink}, original_link = #{originalLink} " +
            "WHERE id = #{id}")
    void update(Link link);

    @Update("UPDATE links SET deleted = now() WHERE id = #{id}")
    void delete(Integer id);

    @Select("SELECT EXISTS (SELECT 1 FROM links WHERE short_link = #{shortLink})")
    Boolean isExistShortLink(String shortLink);

    List<String> getTop(@Param("params") Map<String, Object> params);
}
