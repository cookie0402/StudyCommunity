package study.community.chenqian.controller;

import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.community.chenqian.dto.AccessTokenDTO;
import study.community.chenqian.dto.GithubUser;
import study.community.chenqian.mapper.UserMapper;
import study.community.chenqian.model.User;
import study.community.chenqian.provider.GithubProvider;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
//import study.community.chenqian.provider.GithubProvider;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) throws IOException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);

        System.out.println(githubUser.getName());

        if (githubUser != null ) {
            User user = new User();

            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));

            String token = UUID.randomUUID().toString();
            user.setToken(token);

            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));


            // 登录成功，写cookie 和session
//            request.getSession().setAttribute("user", user);
//            request.getSession().setAttribute("user", githubUser);
            return "redirect:/";
        } else {
            response.sendRedirect("/");
            return null;
        }

    }
}
