package tuto.jms.spring.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import tuto.jms.spring.dto.PersonaDTO;

@Component
public class Receiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	

	@JmsListener(destination = "${activemq.queue.textMessage}", containerFactory = "jmsContainerFactory")
	public void reveiveMessage(String message) {
		LOGGER.info("reveiveMessage: [{}]", message);
	}
	
	
	@JmsListener(destination = "${activemq.queue.objectMessage}")
	public void reveiveObjectMessage(PersonaDTO dto) {
		LOGGER.info("reveiveObjectMessage: [{}]", dto);
	}
}
