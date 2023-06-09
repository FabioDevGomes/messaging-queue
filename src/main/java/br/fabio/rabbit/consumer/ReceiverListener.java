package br.fabio.rabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.fabio.rabbit.UserMessageConfig;
import br.fabio.rabbit.model.User;

@Component
public class ReceiverListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverListener.class);

	@RabbitListener(queues = UserMessageConfig.queueName)
	public void processMessage(Message message, User object) {
		LOGGER.info("::::::::::: >> " + object.getName());
		LOGGER.info("::::::::::: >> " + object.getPhone());
		LOGGER.info("::::::::::: >> " + object.getEmail());
	}

}
