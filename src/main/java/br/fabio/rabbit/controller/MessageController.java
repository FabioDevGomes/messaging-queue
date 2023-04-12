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


@RestController
@RequestMapping("/sendMessage")
public class MessageController {
	
	@Autowired
	SenderMessage senderMessage;
	
	@PostMapping(
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> sendUserMessage(@RequestBody User user) throws Exception {
		senderMessage.sendMessage(user);
		return ResponseEntity.ok().build();
	}

}
