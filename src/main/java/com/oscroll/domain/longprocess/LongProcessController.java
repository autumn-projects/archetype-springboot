package com.oscroll.domain.longprocess;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LongProcessController {

    @RequestMapping("/long-process")
    public String pause() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
        System.out.println("Process finished");
        return "Process finished";
    }
}

