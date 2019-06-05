package com.oscroll.domain.user.http;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String username;
    private String password;

}
