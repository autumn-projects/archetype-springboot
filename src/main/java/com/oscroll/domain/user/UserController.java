package com.oscroll.domain.user;

import com.oscroll.configuration.jwt.JwtUtil;
import com.oscroll.domain.user.http.UserLoginRequest;
import com.oscroll.domain.user.http.UserLoginResponse;
import com.oscroll.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "User", tags = {"用户"})
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    @ResponseBody
    public ResultUtil<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();

        if (userName == null || "".equals(userName)) {
            return new ResultUtil<>("用户名不能为空");
        }
        if (password == null || "".equals(password)) {
            return new ResultUtil<>("密码不能为空");
        }
        if (!userService.checkLogin(userName, password)) {
            return new ResultUtil<>("用户名或密码错误");
        } else {
            String token = JwtUtil.getToken(userName);
            return new ResultUtil<>(new UserLoginResponse(token));
        }
    }

}
