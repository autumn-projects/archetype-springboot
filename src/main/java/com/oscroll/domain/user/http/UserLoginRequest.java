package com.oscroll.domain.user.http;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String userName;
    private String password;

}
