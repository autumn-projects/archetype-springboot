package com.oscroll.domain.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    @Select("select * from user where user_id = #{id}")
    User findOneByUserId(@Param("id") Integer id);

    @Select("select * from user where user_name = #{userName} limit 1")
    User findOneByUserName(@Param("userName") String userName);

}
