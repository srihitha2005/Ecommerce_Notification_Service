package com.example.NotificationService.controller;

import com.example.NotificationService.dto.EmailRequestDTO;
import com.example.NotificationService.service.EmailNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notify")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3001","http://10.65.1.75:3001"})
public class NotificationController {

    private final EmailNotificationService emailService;

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDTO request) {

        emailService.sendEmail(request);
        return ResponseEntity.ok("Email sent successfully");
    }
}