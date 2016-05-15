package tuto.jms.spring.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

@EnableJms
@Configuration
public class Config {
	@Value("${activemq.clientID}")
	private String clientID;
	
	
	@Bean // Strictly speaking this bean is not necessary as boot creates a default
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setClientId(clientID);
        System.out.println("clientID: " + clientID);
        return factory;
    }
	
	
//	@Value("${spring.activemq.broker-url}")
//	private String jmsBrokerUrl;
//	
//	@Value("${spring.activemq.user}")
//	private String user;
//	
//
//	@Value("${spring.activemq.password}")
//	private String password;
	
//    @Bean
//    public ConnectionFactory connectionFactory() {
//    	System.out.println(jmsBrokerUrl);
//        return new ActiveMQConnectionFactory(user, password, jmsBrokerUrl);
//    }
}
