package com.example.NotificationService.service;

import com.example.NotificationService.dto.EmailRequestDTO;
import com.example.NotificationService.util.EmailTemplateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@RequiredArgsConstructor
public class EmailNotificationServiceImpl implements EmailNotificationService {

    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(EmailRequestDTO request) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(request.getTo());
        mail.setSubject(request.getSubject());
        mail.setText(EmailTemplateUtil.buildPlainTextEmail(request.getMessage()));

        mailSender.send(mail);
    }
}
