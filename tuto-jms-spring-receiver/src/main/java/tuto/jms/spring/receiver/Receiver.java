package tuto.jms.spring.receiver;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import tuto.jms.spring.dto.PersonaDTO;

@Component
public class Receiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	

	@JmsListener(destination = "${activemq.queue.textMessage}", containerFactory = "jmsContainerFactory")
	public void reveiveMessage(String message) {
		LOGGER.info("reveiveMessage: [{}]", message);
	}
	
	
	@JmsListener(destination = "${activemq.queue.objectMessage}")
	public void reveiveObjectMessage(String message) {
		PersonaDTO dto;
		
		try {
			dto = objectMapper.readValue(message, PersonaDTO.class);
			LOGGER.info("reveiveObjectMessage: [{}]", dto);
			
		} catch (IOException e) {
			LOGGER.error("Error al intentar convertir JSON en PersonaDTO", e);
		}
	}
}
