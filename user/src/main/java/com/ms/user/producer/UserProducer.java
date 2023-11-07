package com.ms.user.producer;

import com.ms.user.dtos.EmailDto;
import com.ms.user.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate template;

    public UserProducer(RabbitTemplate template) {
        this.template = template;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user){
        EmailDto email = new EmailDto();
        email.setUserId(user.getId());
        email.setEmailTo(user.getEmail());
        email.setTitle("Cadastro Realizado com sucesso");
        email.setText(user.getName() + ", seja bem vindo(a) \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma! ");
        template.convertAndSend("", routingKey,email);
    }
}
