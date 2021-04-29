package com.example.links.dao;

import com.example.links.pojo.StatisticResult;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface ForwardDAO {

    @Insert("INSERT INTO link_forward (created, link_id, user_id) " +
            "VALUES (now(), #{link_id}, #{user_id})")
    void forward(@Param("link_id") Integer id,
                 @Param("user_id") String userId);

    List<StatisticResult> getStatistic(@Param("params") Map<String, Object> params);
}
