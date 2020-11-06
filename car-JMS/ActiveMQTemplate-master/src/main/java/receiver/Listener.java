package receiver;

import javax.jms.Message;
import javax.jms.MessageListener;

public class Listener implements MessageListener {

    @Override
    public void onMessage(Message message){
        System.out.println(message);
    }
}
