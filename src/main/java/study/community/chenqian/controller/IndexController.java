package study.community.chenqian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class IndexController {
    @GetMapping("/")
    public String IndexController(){return "index";}
//    public String hello(@RequestParam(name = "name") String name,Model model){
//        model.addAttribute("name",name);
////        name =
//        return "index";
//
//    }


}
