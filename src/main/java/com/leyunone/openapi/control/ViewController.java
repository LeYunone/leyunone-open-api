package com.leyunone.openapi.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-13
 */

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping("/")
    public String htmlView() {
        return "openapi";
    }
}

