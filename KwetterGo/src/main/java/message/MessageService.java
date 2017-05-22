package message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Jeroen0606 on 22-5-2017.
 */
@MessageDriven(mappedName = "jms/kwetterjms", activationConfig = {@ActivationConfigProperty(propertyName = "acknowledgeMode",
        propertyValue = "Auto-acknowledge"), @ActivationConfigProperty(propertyName = "destinationType",
        propertyValue = "javax.jms.Queue")})
public class MessageService implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.print(message.toString());
    }
}
