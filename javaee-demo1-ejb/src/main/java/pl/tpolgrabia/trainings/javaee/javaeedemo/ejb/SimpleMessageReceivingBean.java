package pl.tpolgrabia.trainings.javaee.javaeedemo.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destinationLookup",
                propertyValue = "java:/jms/queue/MyQueue"),
        @ActivationConfigProperty(
                propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"),
})
public class SimpleMessageReceivingBean implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(SimpleMessageReceivingBean.class);

    @Override
    public void onMessage(Message message) {
        try {
            String data = message.getBody(String.class);
            logger.info("Got message {}", data);
        } catch (JMSException e) {
            throw new IllegalStateException("JMS exception", e);
        }
    }
}
