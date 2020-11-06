package receiver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.*;

public class MyReceiverAsynch {

    public static void main(String[] args) {
        try{

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");

            QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");

            Queue queue = (Queue) applicationContext.getBean("queue");

            QueueConnection connection = factory.createQueueConnection();
            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueReceiver receiver = session.createReceiver(queue);
            
            Listener listener = new Listener();
            receiver.setMessageListener(listener);

            connection.start();

            while (true){
            }


            // Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
            // Open a session
            // start the connection
            // Create a receive
            // Receive the message

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
