package com.javamentors.controller;

import com.javamentors.DTO.AppUserDTO;
import com.javamentors.DTO.AuthenticationRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class AuthorizationController {

    private final String serverUrlLogin;
    private final String startWord;

    public AuthorizationController(@Value("${server.rest.login.url}") String serverUrlLogin,
                                   @Value("${jwt.token.secret.start.word}") String startWord) {
        this.serverUrlLogin = serverUrlLogin;
        this.startWord = startWord;
    }

    @GetMapping(value = "/login")
    public String auth(@ModelAttribute("message") String message) {
        return "login";
    }

    @PostMapping("/login")
    public String getToken(AuthenticationRequestDto authenticationRequestDto, HttpServletRequest request, HttpServletResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<AuthenticationRequestDto> entity = new HttpEntity<>(authenticationRequestDto, headers);
        ResponseEntity<AppUserDTO> result = restTemplate.exchange(serverUrlLogin, HttpMethod.POST, entity, AppUserDTO.class);

        AppUserDTO userDtoFromBody = result.getBody();
        String tokenCode = userDtoFromBody.getToken();
        userDtoFromBody.setToken(startWord + tokenCode);

        HttpSession session = request.getSession();
        session.setAttribute("user", userDtoFromBody);
        session.setAttribute("Authorization", userDtoFromBody.getToken());
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", userDtoFromBody.getToken());

        return "redirect:/userlist";
    }
}
