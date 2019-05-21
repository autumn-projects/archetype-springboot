package com.oscroll.domain.demo;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoMapper {

    @Select("select * from test")
    List<DemoEntity> selectAll();

    DemoEntity findByKey(Integer id);

}
