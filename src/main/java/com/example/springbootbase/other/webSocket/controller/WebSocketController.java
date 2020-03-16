package com.example.springbootbase.other.webSocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bmr
 * @time 2020-03-04 15:49
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketController {
    @GetMapping("/index")
    public String index(){
        return "websocket";
    }
}
