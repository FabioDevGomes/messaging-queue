package br.fabio.rabbit.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import br.fabio.rabbit.UserMessageConfig;
import br.fabio.rabbit.model.User;

import static br.fabio.rabbit.UserMessageConfig.TOPIC_EXCHANGE;


@Component
public class SenderMessage{
	private static final Logger LOGGER = LoggerFactory.getLogger(SenderMessage.class);
	private RabbitTemplate rabbitTemplate;
	private static final String BIDING = "fabio.ampq.teste";

	public SenderMessage(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(User user) throws Exception {
		LOGGER.info("::::::::::: Sending a message... ");
		rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, BIDING, user);
	}

}
