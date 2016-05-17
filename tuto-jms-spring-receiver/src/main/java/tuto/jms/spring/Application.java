package tuto.jms.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import tuto.jms.spring.config.JMSConfig;

@SpringBootApplication
@Import(value = { JMSConfig.class })
public class Application {

	public static void main(String[] args) {
//		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		SpringApplication.run(Application.class, args);
	}
}
