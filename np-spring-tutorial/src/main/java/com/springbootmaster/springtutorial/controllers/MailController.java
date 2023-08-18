package com.springbootmaster.springtutorial.controllers;

import com.springbootmaster.springtutorial.mail.MailSender;
import com.springbootmaster.springtutorial.mail.MockMailSender;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private MailSender mailSender;


    public MailController(MailSender smtp){
        this.mailSender=smtp;
    }
    public void setMailSender(MailSender mailSender){
        this.mailSender=mailSender;
    }
    @RequestMapping("/mail")
    public String mail() throws MessagingException {
        mailSender.send("smithi.mahendran@gmail.com", "test mail", "Body of the test mail");
        return "Hello, world";
    }
}
