package br.fabio.rabbit.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.fabio.rabbit.UserMessageConfig;

@Component
public class ReceiverListener {
	
//	@RabbitListener(
//			bindings = @QueueBinding(value = @Queue(UserMessageConfig.queueName), 
//			exchange = @Exchange(name = UserMessageConfig.topicExchangeName), 
//			key = UserMessageConfig.biding))
	@RabbitListener(queues = UserMessageConfig.queueName)
	public void processMessage(Message message, Object object) {
		System.out.println("::::::::::: >> " + object);
		
	}

}