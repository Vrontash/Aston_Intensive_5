package org.example.service;

import org.example.dto.EmailDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final JavaMailSender emailSender;

    public NotificationService(JavaMailSender mailSender) {
        this.emailSender = mailSender;
    }

    public void sendEmail(EmailDto emailDto){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDto.getEmail());
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getMessage());
        emailSender.send(message);
    }
}
