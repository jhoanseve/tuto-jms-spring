package tuto.jms.spring.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;

@EnableJms
@Configuration
public class JMSConfig {
	@Value("${jms.clientid.queue}")
	private String clientidQueue;
	
	@Value("${jms.clientid.topic}")
	private String clientidTopic;
	
    
    @Value("${jms.cache.size}")
    private int jmsCacheSize;
    
    
    @Bean
    public DefaultJmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory) {
        CachingConnectionFactory ccf = new CachingConnectionFactory(connectionFactory);
        ccf.setClientId(clientidTopic);
        ccf.setSessionCacheSize(jmsCacheSize);
        
        DefaultJmsListenerContainerFactory dmlc = new DefaultJmsListenerContainerFactory();
        dmlc.setPubSubDomain(true);
        dmlc.setConnectionFactory(ccf);
        
        return dmlc;
    }
    
    

    @Bean
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory(ConnectionFactory connectionFactory) {
        CachingConnectionFactory ccf = new CachingConnectionFactory(connectionFactory);
        ccf.setClientId(clientidQueue);
        ccf.setSessionCacheSize(jmsCacheSize);
        
        DefaultJmsListenerContainerFactory dmlc = new DefaultJmsListenerContainerFactory();
        dmlc.setConnectionFactory(ccf);
        
        return dmlc;
    }
}
