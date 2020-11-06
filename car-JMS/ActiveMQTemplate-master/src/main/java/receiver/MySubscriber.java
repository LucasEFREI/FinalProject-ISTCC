package receiver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.*;

public class MySubscriber {

    public static void main(String[] args) {
        try{

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");

            TopicConnectionFactory factory = (TopicConnectionFactory) applicationContext.getBean("connectionFactory");

            Topic topic = (Topic) applicationContext.getBean("topic");

            TopicConnection connection = factory.createTopicConnection();
            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicSubscriber subscriber = session.createSubscriber(topic);

            connection.start();

            Message m = subscriber.receive();
            System.out.println("the message is : " + m);

            session.close();
            connection.close();


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


