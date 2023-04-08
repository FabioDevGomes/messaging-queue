package br.fabio.rabbit.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.fabio.rabbit.UserMessageConfig;


@Component
public class SenderMessage implements CommandLineRunner{
	private final RabbitTemplate rabbitTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(SenderMessage.class);
	
	public SenderMessage(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("::::::::::: Sending a message... ");
		
		rabbitTemplate.convertAndSend(UserMessageConfig.topicExchangeName, "fabio.ampq.teste", "****** Hello from RabbitMq! ******");
	}

}