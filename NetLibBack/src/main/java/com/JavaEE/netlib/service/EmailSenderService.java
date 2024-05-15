package com.JavaEE.netlib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String receiver, String subject, String mailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sitchenko.aa@gmail.com");
        message.setTo(receiver);
        message.setText(mailBody);
        message.setSubject(subject);

        mailSender.send(message);
    }
}
