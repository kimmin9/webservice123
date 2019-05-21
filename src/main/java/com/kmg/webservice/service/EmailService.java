package com.kmg.webservice.service;

import com.kmg.webservice.dto.mail.EmailDto;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    public int emailSend(EmailDto dto) throws MailException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("dkanrjsk7776@naver.com");
        mailMessage.setSubject("홈페이지 문의");
        mailMessage.setText("이름 : " + dto.getName() + "Email : " + dto.getEmail() + "내용 : " + dto.getMessage());
        try{
            javaMailSender.send(mailMessage);
            return ;
        }catch (MailException mailException){
            return 0;
        }

    }
}

