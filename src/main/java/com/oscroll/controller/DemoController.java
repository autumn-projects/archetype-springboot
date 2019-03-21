package com.oscroll.controller;

import com.oscroll.entity.DemoEntity;
import com.oscroll.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/find")
    @ResponseBody
    public List<DemoEntity> findAll(){
        return demoService.findAll();
    }

}
