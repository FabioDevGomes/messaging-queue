package br.fabio.rabbit.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverV2 {
	
	@RabbitListener(
			bindings = @QueueBinding(value = @Queue("spring-boot"), 
			exchange = @Exchange("fabio-exchange-b"), 
			key = "fabio.ampq.tes"))
	public void processMessage(Message message, String object) {
		System.out.println("::::::::::: >> " + object);
		
	}

}
