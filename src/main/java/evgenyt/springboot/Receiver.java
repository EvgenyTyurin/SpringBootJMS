package evgenyt.springboot;

import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Listen to testQueue and print incoming messages
 * @author EUTyrin
 *
 */

@Component
public class Receiver {

	@JmsListener(destination = "testQueue")
	public void receiveMessage(Message msg) throws JMSException {
		if (msg instanceof ActiveMQTextMessage) {			
			System.out.println("Received: " + ((ActiveMQTextMessage) msg).getText());
		} else {
			System.out.println("Unsupported message type received " + msg.getClass());
		}			
	}

}
