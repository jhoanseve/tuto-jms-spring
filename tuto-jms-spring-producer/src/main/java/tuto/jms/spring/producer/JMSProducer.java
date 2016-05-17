package tuto.jms.spring.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import tuto.jms.spring.dto.PersonaDTO;

@Component
public class JMSProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JMSProducer.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${activemq.queue.textMessage}")
	private String queueTextMessage;
	
	@Value("${activemq.queue.objectMessage}")
	private String queueObjectMessage;
	
	
	public void sendTextMessage() {
		LOGGER.info("Start sending message...!");

		MessageCreator messageCreator = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("ping!");
			}
		};

		LOGGER.info("Sending a new message.");
		jmsTemplate.send(queueTextMessage, messageCreator);
	}
	
	

	public void sendObjectMessage() {
		LOGGER.info("Start sending message...!");

		MessageCreator messageCreator = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				PersonaDTO persona = new PersonaDTO("123456789", "Pedro", "Perez");
				return session.createObjectMessage(persona);
			}
		};

		LOGGER.info("Sending a new message.");
		jmsTemplate.send(queueObjectMessage, messageCreator);
	}
}
