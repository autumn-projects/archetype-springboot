package com.oscroll.domain.user;

import com.oscroll.configuration.security.SecurityUserDetails;
import com.oscroll.domain.system.Menu;
import com.oscroll.domain.user.http.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

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

    /**
     * 定义角色
     */
    public static List<Role> ALL_ROLES = new ArrayList();
    public static List<Role> ADMIN_ROLES = new ArrayList();
    public static List<Role> COMMON_ROLES = new ArrayList();
    /**
     * 定义权限
     */
    public static List<Menu> ADMIN_MENUS = new ArrayList();
    public static List<Menu> COMMON_MENUS = new ArrayList();

    static {
        //定义菜单
        Menu commonMenu1 = new Menu(1, "首页", "/security/common", 0);
        Menu commonMenu2 = new Menu(2, "服务", "/security/service", 0);
        Menu commonMenu3 = new Menu(3, "公司", "/security/company", 0);
        Menu adminMenu = new Menu(4, "系统管理", "/security/manager", 0);
        //初始化菜单
        ADMIN_MENUS.add(adminMenu);
        ADMIN_MENUS.add(commonMenu1);
        ADMIN_MENUS.add(commonMenu2);
        ADMIN_MENUS.add(commonMenu3);
        COMMON_MENUS.add(commonMenu1);
        COMMON_MENUS.add(commonMenu2);
        COMMON_MENUS.add(commonMenu3);
        //定义角色
        Role adminRole = new Role(1, "admin");
        Role commonRole = new Role(2, "common");
        adminRole.setMenus(ADMIN_MENUS);
        commonRole.setMenus(COMMON_MENUS);
        //初始化角色
        ADMIN_ROLES.add(adminRole);
        ADMIN_ROLES.add(commonRole);
        COMMON_ROLES.add(commonRole);
        ALL_ROLES.add(adminRole);
        ALL_ROLES.add(commonRole);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username" + username);
        User user = userMapper.findOneByUserName(username);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role(1,"admin"));
        user.setRoles(ADMIN_ROLES);
        System.out.println("user:" + user);
        return new SecurityUserDetails(user);
    }
}
