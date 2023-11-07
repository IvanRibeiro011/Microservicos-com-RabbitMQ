package com.ms.email.consumers;

import com.ms.email.dto.EmailRecordDto;
import com.ms.email.model.Email;
import com.ms.email.repository.EmailRepository;
import com.ms.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final EmailService service;

    public EmailConsumer(EmailService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto){
        Email email = new Email();
        BeanUtils.copyProperties(emailRecordDto,email);
        service.sendEmail(email);
    }
}
