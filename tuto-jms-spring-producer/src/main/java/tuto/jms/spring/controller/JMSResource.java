package tuto.jms.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tuto.jms.spring.producer.JMSProducer;

@RestController
public class JMSResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(JMSResource.class);

	@Autowired
	private JMSProducer jmsProducer;
	
	@RequestMapping(value = "/send")
	public void sendJMSMessage() {
		LOGGER.info("Iniciando envio de mensaje JMS...");
		
		jmsProducer.send();
	}
}
