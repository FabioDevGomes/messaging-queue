package br.fabio.rabbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fabio.rabbit.model.User;
import br.fabio.rabbit.producer.SenderMessage;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;


@RestController
@RequestMapping("/sendMessage")
public class MessageController {
	
	@Autowired
	SenderMessage senderMessage;


	@PostMapping(consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public ResponseEntity<?> sendUserMessage(@RequestBody User user) throws Exception {
		senderMessage.sendMessage(user);
		return ResponseEntity.ok().build();
	}

//	@PostMapping(path = "/geral", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//	public ResponseEntity<?> sendUserMessageQueueDirect(@RequestBody User user) throws Exception {
//		senderMessage.sendMessageQueueDirect(user);
//		return ResponseEntity.ok().build();
//	}

}
