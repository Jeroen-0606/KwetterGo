package message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Jeroen0606 on 22-5-2017.
 */
@MessageDriven(mappedName = "jms/kwetterjms", activationConfig = {@ActivationConfigProperty(propertyName = "acknowledgeMode",
        propertyValue = "Auto-acknowledge"), @ActivationConfigProperty(propertyName = "destinationType",
        propertyValue = "javax.jms.Queue")})
public class MessageService implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.print("-------------------------");
        try {
            TextMessage txtMessage = (TextMessage) message;
            String newMessage = txtMessage.getText();
            String username = newMessage.split(": ")[0];
            String kweet = newMessage.split(": ")[1];
            System.out.print(username + " : " + kweet);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
