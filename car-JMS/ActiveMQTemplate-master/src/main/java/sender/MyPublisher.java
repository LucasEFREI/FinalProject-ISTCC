package sender;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.*;

public class MyPublisher {


    public static void main(String[] args) {

        try{

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
            TopicConnectionFactory factory = (TopicConnectionFactory) applicationContext.getBean("connectionFactory");

            Topic topic = (Topic) applicationContext.getBean("topic");

            TopicConnection connection = factory.createTopicConnection();
            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicPublisher publisher = session.createPublisher(topic);

            connection.start();

            TextMessage m = session.createTextMessage("test");
            publisher.send(m);

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
