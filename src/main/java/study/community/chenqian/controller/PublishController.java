package study.community.chenqian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.community.chenqian.dto.QuestionDTO;
import study.community.chenqian.mapper.QuestionMapper;
import study.community.chenqian.mapper.UserMapper;
import study.community.chenqian.model.Question;
import study.community.chenqian.model.User;
import study.community.chenqian.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {


    @Autowired
    private QuestionService questionService;


    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Integer id,
                       Model model){
        QuestionDTO question = questionService.getById(id);
        model.addAttribute("title", question.getTitle());
        model.addAttribute("description", question.getDescription());
        model.addAttribute("tag", question.getTag());
        model.addAttribute("id",question.getId());

        return "publish";
    }


    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "id", required = false) Integer id,
            HttpServletRequest request, Model model
    ){
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if (title == null || title == "") {
            model.addAttribute("error", "??????????????????");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "????????????????????????");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "??????????????????");
            return "publish";
        }




        User user = (User)request.getSession().getAttribute("user");

        if (user==null){
            model.addAttribute("error","???????????????");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_create());
        question.setId(id);


        questionService.createOrUpdate(question);
        return "redirect:/";

    }
}
