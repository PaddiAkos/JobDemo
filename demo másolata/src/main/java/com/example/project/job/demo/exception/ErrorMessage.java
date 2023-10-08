package com.example.project.job.demo.exception;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ErrorMessage {

    private String errorMassage;

    private Instant errorDate;

    private String httpStatus;

    private String contextPath;
}

