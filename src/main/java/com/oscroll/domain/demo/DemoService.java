package com.oscroll.domain.demo;

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

    public DemoEntity findByKey(Integer id){
        return demoMapper.findByKey(id);
    }
}
