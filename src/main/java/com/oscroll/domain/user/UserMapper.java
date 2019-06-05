package com.oscroll.domain.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {

    @Select("select * from user where user_id = #{id}")
    User findOneByUserId(@Param("id") Integer id);

    @Select("select * from user where user_name = #{userName} limit 1")
    User findOneByUserName(@Param("userName") String userName);

    @Select("select b.role_name from user_role a left join role b on a.role_id = b.role_id where a.user_id = #{id}")
    List<String> findRolesByUserId(@Param("id") Integer id);

}
