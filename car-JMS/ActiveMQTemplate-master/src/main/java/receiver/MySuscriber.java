package receiver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.*;

public class MySuscriber {
    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
            TopicConnectionFactory factory = (TopicConnectionFactory) applicationContext.getBean("connectionFactory");

            Topic topic = (Topic) applicationContext.getBean("topic");

            TopicConnection connection = factory.createTopicConnection();

            TopicSession session = connection.createTopicSession(true, Session.AUTO_ACKNOWLEDGE);

            connection.start();

            TopicSubscriber subscriber = session.createSubscriber(topic);

            Message m = subscriber.receive();
            System.out.println(m);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}