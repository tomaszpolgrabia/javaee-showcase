package pl.tpolgrabia.trainings.javaee.javaeedemo.ejb;

import javax.ejb.Local;

@Local
public interface SimpleMessageSendingBean {
    void sendHello(String what);
}
