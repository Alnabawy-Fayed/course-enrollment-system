package com.example.courseenrollmentsystem.dto;

import lombok.Data;

@Data
public class SubscriptionRequest {
    private long studentId;
    private long courseId;
}
