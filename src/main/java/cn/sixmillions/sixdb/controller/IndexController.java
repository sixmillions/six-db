package cn.sixmillions.sixdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "This is my database.";
    }
}
