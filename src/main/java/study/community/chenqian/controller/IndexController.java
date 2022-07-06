package study.community.chenqian.controller;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import study.community.chenqian.dto.PaginationDTO;
import study.community.chenqian.dto.QuestionDTO;
import study.community.chenqian.mapper.QuestionMapper;
import study.community.chenqian.mapper.UserMapper;
import study.community.chenqian.model.Question;
import study.community.chenqian.model.User;
import study.community.chenqian.service.QuestionService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;


    @GetMapping("/")
    public String IndexController(HttpServletRequest request,
                                  Model model,
                                  @RequestParam(name = "page",defaultValue = "1") Integer page,
                                  @RequestParam(name = "size",defaultValue = "2") Integer size){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length!=0){
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
        }

        PaginationDTO pagination = questionService.list(page,size);

        model.addAttribute("pagination",pagination);
        return "index";
    }


}
