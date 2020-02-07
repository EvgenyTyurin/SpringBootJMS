package evgenyt.springboot;


import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


/**
 * Spring Boot example
 * Send text message to AMQ broker and receive it back in Receiver class
 * Don't forget to configure broker url in application.properties
 * @author EUTyrin
 *
 */

@SpringBootApplication
@EnableJms
public class SpringbootJmsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(SpringbootJmsApplication.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		System.out.println("Input message to send or exit to stop app:");
		Scanner in = new Scanner(System.in);		
		do {
			// ask user for message
			String s = in.next();
			if (s.equals("exit"))
				System.exit(0);
			System.out.println("Sending txt message: " + s);
			// send text to queue
			jmsTemplate.send("testQueue", session -> session.createTextMessage(s));
		} while (true);
	}		
		
}
