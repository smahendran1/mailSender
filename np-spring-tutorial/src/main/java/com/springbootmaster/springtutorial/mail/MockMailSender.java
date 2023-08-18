package com.springbootmaster.springtutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class MockMailSender implements MailSender{

    public static Log log = LogFactory.getLog(MockMailSender.class);
    public void send(String to, String subject, String body){
log.info("Sending MOCK mail to " + to);
        log.info("with subject " + subject);
        log.info("and body " + body);
    }
}
