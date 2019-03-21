package com.oscroll.service;

import com.oscroll.entity.DemoEntity;
import com.oscroll.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public List<DemoEntity> findAll(){
        return demoMapper.selectAll();
    }

}
