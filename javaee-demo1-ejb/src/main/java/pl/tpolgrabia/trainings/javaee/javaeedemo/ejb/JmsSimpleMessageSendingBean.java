package pl.tpolgrabia.trainings.javaee.javaeedemo.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Stateless
@Path("/hello")
public class JmsSimpleMessageSendingBean implements SimpleMessageSendingBean {

    private static final Logger logger = LoggerFactory.getLogger(JmsSimpleMessageSendingBean.class);

    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/queue/MyQueue")
    private Queue queue;

    @Override
    @Path("/say/{what}")
    public void sendHello(
            @PathParam("what") String what) {

        try (JMSContext ctx = connectionFactory.createContext()) {
            logger.info("Sending hello {}", what);
            ctx.createProducer().send(queue, what);
        }
    }
}
