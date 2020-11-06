package com.univ.service;

import com.univ.model.Car;
import com.univ.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.jms.*;
import javax.jms.Queue;

@Service
public class CarRentalService {

    @Autowired
    public
    CarRepository carRepository;

    public void sendMsg() {
        try{
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
            QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");

            Queue queue = (Queue) applicationContext.getBean("queue");
            QueueConnection connection = factory.createQueueConnection();
            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            connection.start();
            QueueSender sender = session.createSender(queue);

            TextMessage msg = session.createTextMessage("msg from BE");
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

    public Car save(Car car){return carRepository.save(car);}

    public Iterable<Car> findAll() {
        return null;
    }
}
