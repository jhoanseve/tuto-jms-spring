package tuto.jms.spring.receiver;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import tuto.jms.spring.dto.PersonaDTO;

@Component
public class Receiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	private static ObjectMapper objectMapper = new ObjectMapper();

	
	@JmsListener(destination = "${jms.topic.textMessage}", containerFactory = "jmsTopicListenerContainerFactory")
	public void reveiveMessage(String message) {
		LOGGER.info("reveiveMessage: [{}]", message);
	}


	@SendTo("${jms.queue.resendObjectMessaje}")
	@JmsListener(destination = "${jms.queue.objectMessage}", containerFactory = "jmsQueueListenerContainerFactory")
	public String reveiveObjectMessage(String message) {
		PersonaDTO dto;

		try {
			dto = objectMapper.readValue(message, PersonaDTO.class);
			LOGGER.info("reveiveObjectMessage: [{}]", dto);

			dto.setApellidos("Nuevo Apellido");

			return objectMapper.writeValueAsString(dto);
		} catch (IOException e) {
			LOGGER.error("Error al intentar convertir JSON en PersonaDTO", e);
		}

		return null;
	}
}
