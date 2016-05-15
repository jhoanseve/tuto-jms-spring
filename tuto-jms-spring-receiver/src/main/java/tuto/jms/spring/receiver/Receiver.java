package tuto.jms.spring.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	@JmsListener(destination = "mailbox-destination", containerFactory = "jmsContainerFactory")
	public void reveiveMessage(String message) {
		LOGGER.info("reveiveMessage: {}", message);
	}
}
