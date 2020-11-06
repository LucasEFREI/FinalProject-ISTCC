package sender;

import javax.jms.*;
import javax.jms.QueueConnectionFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySender {

	public static void main(String[] args) {
		
		try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Queue queue = (Queue) applicationContext.getBean("queue");

			QueueConnection connection = factory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);

			connection.start();

			TextMessage m = session.createTextMessage("AAAAAAAAAAAAAtest");
			sender.send(m);

			session.close();
			connection.close();






			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
			// Open a session without transaction and acknowledge automatic
			// Start the connection
			// Create a sender
			// Create a message
			// Send the message
			// Close the session
			// Close the connection

		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
