package com.ms.user.dtos;

import java.util.UUID;

public class EmailDto {
    private UUID userId;
    private String emailTo;
    private String title;
    private String text;

    public EmailDto(){}

    public EmailDto(UUID userId, String emailTo, String title, String text) {
        this.userId = userId;
        this.emailTo = emailTo;
        this.title = title;
        this.text = text;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
