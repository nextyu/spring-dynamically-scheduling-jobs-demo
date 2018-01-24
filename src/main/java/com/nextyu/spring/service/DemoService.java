package com.nextyu.spring.service;

import cn.hutool.core.lang.Console;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public void sayHi() {
        Console.log("sayHi sayHi sayHi sayHi");
    }
}
