package pl.tpolgrabia.trainings.javaee.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.tpolgrabia.trainings.javaee.javaeedemo.ejb.SimpleMessageSendingBean;
import pl.tpolgrabia.trainings.javaee.javaeedemo.ejb.TodosDao;
import pl.tpolgrabia.trainings.javaee.javaeedemo.ejb.UserDao;
import pl.tpolgrabia.trainings.javaee.javaeedemo.entities.User;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class HelloController implements Serializable {
    private static final long serialVersionUID = 2780964279445984180L;
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Inject
    private TodosDao todosDao;

    @Inject
    private UserDao userDao;

    @Inject
    private SimpleMessageSendingBean simpleMessageSendingBean;

    private String message;
    private boolean markedAsDanger = false;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getAllTodos() {
        return todosDao.findAll();
    }

    public boolean isMarkedAsDanger() {
        return markedAsDanger;
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public String handleSubmit() {
        logger.info("Submitting message {}", message);
        simpleMessageSendingBean.sendHello(message);
        return "index";
    }

    public void toggleButtonClass() {
        this.markedAsDanger = !markedAsDanger;
        logger.info("Hello action");
    }

    @PostConstruct
    public void init() {
        this.message = "Submit me";
        logger.info("Initialized with message {}", message);
    }
}
