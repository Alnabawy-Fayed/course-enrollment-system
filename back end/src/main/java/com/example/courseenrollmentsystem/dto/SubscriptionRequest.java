package com.example.courseenrollmentsystem.dto;

import lombok.Data;

@Data
public class SubscriptionRequest {
    private Long studentId;
    private Long courseId;
}
