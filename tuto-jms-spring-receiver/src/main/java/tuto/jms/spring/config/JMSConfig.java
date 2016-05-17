package tuto.jms.spring.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

@EnableJms
@Configuration
public class JMSConfig {
	@Value("${activemq.clientID}")
	private String clientID;
	
	@Value("${activemq.trustedPackages}")
	private String[] trustedPackages;
	
	
	@Bean // Strictly speaking this bean is not necessary as boot creates a default
    JmsListenerContainerFactory<?> jmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setClientId(clientID);
        System.out.println("clientID: " + clientID);
        System.out.println(connectionFactory instanceof ActiveMQConnectionFactory);
        
        ((ActiveMQConnectionFactory) connectionFactory).setTrustedPackages(Arrays.asList(trustedPackages));
        return factory;
    }
}
