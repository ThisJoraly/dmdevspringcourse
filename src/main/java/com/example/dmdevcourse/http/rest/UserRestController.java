package com.example.dmdevcourse.http.rest;

import com.example.dmdevcourse.service.CompanyService;
import com.example.dmdevcourse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public String findAll(Model model) {
//        model.addAttribute("users", userService.findAll(filter));
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }
}
