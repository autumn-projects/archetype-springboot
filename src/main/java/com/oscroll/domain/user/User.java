package com.oscroll.domain.user;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {

    private Integer userId;
    private String userName;
    private String password;
    private String avatar;
    private Date createTime;
    private List<Role> roles;

}
