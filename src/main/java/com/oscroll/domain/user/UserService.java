package com.oscroll.domain.user;

import com.oscroll.domain.user.http.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer getUserId(String userName, String password) {
        User user = userMapper.findOneByUserName(userName);
        if (user == null || !user.getPassword().equals(password)) return null;
        return user.getUserId();
    }

    public UserInfoResponse getUserInfo(Integer id) {
        UserInfoResponse userInfo = new UserInfoResponse();
        User user = userMapper.findOneByUserId(id);
        List<String> roles = userMapper.findRolesByUserId(id);

        if (user == null) return null;

        userInfo.setName(user.getUserName());
        userInfo.setAvatar(user.getAvatar());
        userInfo.setRoles(roles);
        return userInfo;
    }

}
