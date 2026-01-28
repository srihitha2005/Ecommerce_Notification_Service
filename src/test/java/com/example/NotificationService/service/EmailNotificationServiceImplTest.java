package com.example.NotificationService.service;

import com.example.NotificationService.dto.EmailRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EmailNotificationServiceImplTest {

    private final JavaMailSender mailSender = mock(JavaMailSender.class);
    private final EmailNotificationServiceImpl service =
            new EmailNotificationServiceImpl(mailSender);

    @Test
    void sendEmail_sendsMail() {

        EmailRequestDTO dto = new EmailRequestDTO();
        dto.setTo("test@example.com");
        dto.setSubject("Test");
        dto.setMessage("Hello");

        service.sendEmail(dto);

        verify(mailSender, times(1))
                .send(any(SimpleMailMessage.class));
    }
}