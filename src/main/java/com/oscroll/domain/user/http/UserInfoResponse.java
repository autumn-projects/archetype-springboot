package com.oscroll.domain.user.http;

import lombok.Data;

import java.util.List;

@Data
public class UserInfoResponse {

    private String introduction;
    private String avatar;
    private String name;
    private List<String> roles;

}
