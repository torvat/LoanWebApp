package no.zdata.torva.houseingloanweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AutoDirect {

    @GetMapping
    public String autoDirect(){
        return "calculator";
    }

}

