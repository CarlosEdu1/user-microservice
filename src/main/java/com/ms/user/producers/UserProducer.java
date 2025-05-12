package com.ms.user.producers;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel){
        var emailDto = new EmailDto();
        emailDto.setUuid(userModel.getId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Olá ");
        emailDto.setText(userModel.getName() + ", seja Bem Vindo(a)!\n Agradecemos pelo cadastro na nossa plataforma");

        rabbitTemplate.convertAndSend("",routingKey,emailDto);
    }
}
