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

import java.util.Arrays;
import java.util.List;

@Configuration
public class UserMessageConfig {
	public static final String TOPIC_EXCHANGE = "fabio-topic-exchange";
	public static final String DIRECT_QUEUE = "direct-queue";
	public static final String BIDING = "fabio.ampq.#";

	@Bean
	Queue queue() {
		return new Queue(DIRECT_QUEUE, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(TOPIC_EXCHANGE);
	}

	@Bean
	Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(BIDING);
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
