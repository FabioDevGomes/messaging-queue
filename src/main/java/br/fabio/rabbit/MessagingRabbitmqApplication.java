package br.fabio.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.fabio.rabbit.receiver.Receiver;
import br.fabio.rabbit.receiver.ReceiverV2;

@SpringBootApplication
public class MessagingRabbitmqApplication {
	
	static final String topicExchangeName = "fabio-exchange-b";
	static final String queueName = "spring-boot";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("fabio.ampq.#");
	}
	
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
	
	public static void main(String[] args) {
		SpringApplication.run(MessagingRabbitmqApplication.class, args);
	}
	
	

}
