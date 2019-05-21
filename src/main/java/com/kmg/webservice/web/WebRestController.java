package com.kmg.webservice.web;

import com.kmg.webservice.dto.mail.EmailDto;
import com.kmg.webservice.dto.posts.PostsSaveRequestDto;
import com.kmg.webservice.service.EmailService;
import com.kmg.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private EmailService emailService;

    @GetMapping("/hello")
    public String hello(){
        return "Helloworld1";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @PostMapping("/email")
    public int email(@RequestBody EmailDto dto){
        try {
            return emailService.emailSend(dto);
        }catch (MailException mailException){
            return 0;
        }
    }





}
