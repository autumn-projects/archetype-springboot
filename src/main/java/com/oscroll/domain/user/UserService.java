package com.oscroll.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean checkLogin(String userName, String password) {
        User user = userMapper.findOneByUserName(userName);
        if (user == null) return false;
        System.out.println(user.getPassword());
        System.out.println(password);
        return user.getPassword().equals(password);
    }

    public User findUser(Integer id) {
        return userMapper.findOneByUserId(id);
    }

}
