package com.oscroll.domain.user;

import com.oscroll.domain.system.Menu;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Role {

    private Integer roleId;
    private String roleName;
    private List<Menu> menus;

    public Role(Integer id, String name) {
        this.roleId = id;
        this.roleName = name;
    }
}
