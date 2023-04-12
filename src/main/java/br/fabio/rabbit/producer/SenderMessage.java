package br.fabio.rabbit.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.fabio.rabbit.UserMessageConfig;
import br.fabio.rabbit.model.User;


@Component
public class SenderMessage{
	private final RabbitTemplate rabbitTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(SenderMessage.class);
	
	public SenderMessage(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(User user) throws Exception {
		LOGGER.info("::::::::::: Sending a message... ");
		rabbitTemplate.convertAndSend(UserMessageConfig.topicExchangeName, "fabio.ampq.teste", user);
	}

}
