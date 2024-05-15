package com.JavaEE.netlib;

import com.JavaEE.netlib.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class NetLibApplication {
    @Autowired
    private EmailSenderService senderService;
    public static void main(String[] args) {
        SpringApplication.run(NetLibApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {
//        senderService.sendMail("iruzhilov@gmail.com", "люблю тётю Юлю", "тётю Юля крашиха");
//        senderService.sendMail("sapargali.alimkhan@gmail.com", "люблю тётю Баян", "тётя Баян крашиха");
        senderService.sendMail("dilya-zh04@mail.ru", "люблю дильназ", "люблю дильназ");

    }
}