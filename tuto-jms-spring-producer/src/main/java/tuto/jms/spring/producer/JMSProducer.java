package tuto.jms.spring.producer;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

@Component
public class JMSProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JMSProducer.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@PostConstruct
	private void init() {
		System.out.println("Test");
		FileSystemUtils.deleteRecursively(new File("activemq-data"));
	}
	
	
	public void send() {
		LOGGER.info("Start sending message...!");
		
		MessageCreator messageCreator = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("ping!");
			}
		};


		LOGGER.info("Sending a new message.");
		jmsTemplate.send("mailbox-destination", messageCreator);
	}
}
