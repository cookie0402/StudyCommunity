package study.community.chenqian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import study.community.chenqian.mapper.UserMapper;
import study.community.chenqian.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String IndexController(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user", user);
                }
                break;
            }

        }


        return "index";}
//    public String hello(@RequestParam(name = "name") String name,Model model){
//        model.addAttribute("name",name);
////        name =
//        return "index";
//
//    }


}
