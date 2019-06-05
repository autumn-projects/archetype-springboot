package com.oscroll.domain.demo;

import com.oscroll.configuration.jwt.JwtUtil;
import com.oscroll.configuration.jwt.LoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "Demo", tags = {"实例"})
@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ApiOperation(value = "查找全部")
    @GetMapping("/find")
    @ResponseBody
    public List<DemoEntity> findAll() {
        return demoService.findAll();
    }

    @ApiOperation(value = "查找")
    @GetMapping("/findOne")
    @ResponseBody
    public DemoEntity findByKey(Integer id) {
        return demoService.findByKey(id);
    }

}
