package com.javamentors.controller;

import com.javamentors.DTO.AppUserDTO;
import com.javamentors.DTO.AuthenticationRequestDto;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserListController {

    @GetMapping("/userlist")
    public String userList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Authorization", (String) (session.getAttribute("Authorization")));
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<AuthenticationRequestDto> entity = new HttpEntity<>( header);
//        ResponseEntity<AppUserDTO> result = restTemplate.exchange("http://localhost:8075/api/v1/admin/userlist", HttpMethod.GET, entity, AppUserDTO.class);
//
//        AppUserDTO userDtoFromBody = result.getBody();
        return "userlist";
    }
}
