package com.springbootmaster.springtutorial.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {


  @Bean
    @ConditionalOnProperty(name="spring.mail.host", havingValue="foo",
    matchIfMissing=true)
    @Profile("dev")//this means that this bean will only be configured in the dev environment
    public MailSender mockMailSender(){
        return new MockMailSender();
    }//returned values will be stored in the application context as beans

    @Bean
    @ConditionalOnProperty("spring.mail.host")
    @Profile("!dev")
    public MailSender smtpMailSender(JavaMailSender javaMailSender){
        return new SmtpMailSender(javaMailSender);
    }

}
