package br.fabio.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class UserMessageConfig {
	public static final String topicExchangeName = "fabio-topic-exchange";
	public static final String queueName = "teste-direct";
	public static final String queueName2 = "teste-direct2";
	public static final String biding = "fabio.ampq2.#";

	@Bean
	Queue queue() {
		return new Queue(queueName2, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(biding);
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(new JavaTimeModule());
		
		return new Jackson2JsonMessageConverter(mapper);
	}
}
