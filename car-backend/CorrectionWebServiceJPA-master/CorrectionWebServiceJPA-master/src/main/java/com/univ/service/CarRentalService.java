package com.univ.service;

import com.univ.model.Car;
import com.univ.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.jms.*;
import javax.jms.Queue;
import java.util.Random;

@Service
public class CarRentalService {

    @Autowired
    public
    CarRepository carRepository;

    public void sendMsg(String request) {
        try{
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
            QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");

            Queue queue = (Queue) applicationContext.getBean("queue");
            QueueConnection connection = factory.createQueueConnection();
            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            connection.start();
            QueueSender sender = session.createSender(queue);

            TextMessage msg;

            if (request.equals("GET"))
            {
                msg = session.createTextMessage("GET");
            }
            else if (request.equals("PUT"))
            {
                msg = session.createTextMessage("PUT");
            }
            else if (request.equals("POST"))
            {
                msg = session.createTextMessage("POST");
            }
            else if (request.equals("DELETE"))
            {
                msg = session.createTextMessage("DELETE");
            }
            else
            {
                msg = session.createTextMessage("UNIDENTIFIED REQUEST");
            }

            sender.send(msg, DeliveryMode.PERSISTENT, 4, 10000);

            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public CarRentalService(CarRepository carRepository){
        this.carRepository = carRepository;
        Car ferrari = new Car("11AA22", "Ferrari", 1000);
		carRepository.save(ferrari);
		//cars.add(ferrari);
        Car clio = new Car("22BB33", "Clio", 200);
		carRepository.save(clio);
        Car twingo = new Car("33CC44", "Twingo", 300);
		carRepository.save(twingo);
    }

    public String generatePlateNumber() {
        String plateNumber = new String("");
        for (int i=0; i<=2; i++) {
            Random rnd = new Random();
            char c = (char) ('A' + rnd.nextInt(26));
            plateNumber += c;
        }
        for (int i=0; i<=3; i++) {
            Random rnd = new Random();
            int ri =  rnd.nextInt(10);
            String s = Integer.toString(ri);
            plateNumber += s;
        }
        return plateNumber;
    }

    public Car save(Car car){return carRepository.save(car);}

    public void remove(Car car){carRepository.delete(car);}

    public Iterable<Car> findAll() {
        return null;
    }
}
