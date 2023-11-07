package com.ms.email.dto;

import java.util.UUID;

public record EmailRecordDto(UUID userId,
                             String emailTo,
                             String title,
                             String text) {
}
