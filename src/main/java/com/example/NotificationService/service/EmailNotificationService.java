package com.example.NotificationService.service;

import com.example.NotificationService.dto.EmailRequestDTO;

public interface EmailNotificationService {
    void sendEmail(EmailRequestDTO request);
}