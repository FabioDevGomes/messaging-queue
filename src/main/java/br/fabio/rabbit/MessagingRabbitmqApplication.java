package br.fabio.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessagingRabbitmqApplication {
	
//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter adapter) {
//		var container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(queueName);;
//		container.setMessageListener(adapter);
//		
//		return container;
//	}
	
//	@Bean
//	MessageListenerAdapter listenerAdapter(ReceiverV2 receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessage");
//	}
	
//	@Bean
//	public MessageConverter josnMessageConverter() {
//		
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(MessagingRabbitmqApplication.class, args);
	}
	
	
	
	

}
