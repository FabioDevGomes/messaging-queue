package br.fabio.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.fabio.rabbit.receiver.Receiver;
import br.fabio.rabbit.receiver.ReceiverV2;

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
