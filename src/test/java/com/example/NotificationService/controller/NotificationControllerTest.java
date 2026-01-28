package com.example.NotificationService.controller;

import com.example.NotificationService.dto.EmailRequestDTO;
import com.example.NotificationService.service.EmailNotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotificationController.class) // <--- Use this instead of @EnableWebMvc
class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmailNotificationService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void sendEmail_returns200() throws Exception {
        EmailRequestDTO dto = new EmailRequestDTO();
        dto.setTo("test@example.com");
        dto.setSubject("Test");
        dto.setMessage("Hello");

        // Use any() if the controller might create a new instance
        // or just your dto if you're sure it's the exact same object
        doNothing().when(emailService).sendEmail(any(EmailRequestDTO.class));

        mockMvc.perform(
                post("/api/notify/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
        ).andExpect(status().isOk());
    }
}