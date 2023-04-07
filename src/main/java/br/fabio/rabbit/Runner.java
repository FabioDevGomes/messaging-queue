package br.fabio.rabbit;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Runner implements CommandLineRunner{
	private final RabbitTemplate rabbitTemplate;
	//private final Receiver receiver;
	
	public Runner(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		//this.receiver = receiver;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("::::::::::: Sending a message... ");
		
		rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.topicExchangeName, "fabio.ampq.teste", ":::::::::: Hello from RabbitMq!");
		//receiver.getDownLatch().await(10000, TimeUnit.MILLISECONDS);
	}

}
