package com.oscroll.domain.user;

import com.oscroll.configuration.jwt.JwtUtil;
import com.oscroll.configuration.jwt.LoginToken;
import com.oscroll.domain.user.http.UserInfoResponse;
import com.oscroll.domain.user.http.UserLoginRequest;
import com.oscroll.domain.user.http.UserLoginResponse;
import com.oscroll.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(value = "User", tags = {"用户"})
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    @ResponseBody
    public ResultUtil<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        String userName = request.getUsername();
        String password = request.getPassword();

        if (userName == null || "".equals(userName)) {
            return new ResultUtil<>("用户名不能为空");
        }
        if (password == null || "".equals(password)) {
            return new ResultUtil<>("密码不能为空");
        }

        Integer userId = userService.getUserId(userName, password);
        if (userId == null) {
            return new ResultUtil<>("用户名或密码错误");
        } else {
            String token = JwtUtil.getToken(userId);
            return new ResultUtil<>(new UserLoginResponse(token));
        }
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    @LoginToken
    @ResponseBody
    public ResultUtil<UserInfoResponse> info(String token) {
        Integer userId = JwtUtil.parseToken(token);
        UserInfoResponse response = userService.getUserInfo(userId);

        if (response == null) {
            return new ResultUtil<>("查询不到该用户");
        }
        return new ResultUtil<>(response);
    }

    @ApiOperation(value = "用户注销")
    @PostMapping("/logout")
    @LoginToken
    @ResponseBody
    public ResultUtil logout(HttpServletRequest request) {
        log.info("用户注销:{}", request.getHeader("X-Token"));
        return new ResultUtil();
    }

}
