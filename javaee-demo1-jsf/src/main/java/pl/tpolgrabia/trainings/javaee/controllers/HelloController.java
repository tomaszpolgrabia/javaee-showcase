package pl.tpolgrabia.trainings.javaee.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.tpolgrabia.trainings.javaee.javaeedemo.ejb.TodosDao;
import pl.tpolgrabia.trainings.javaee.javaeedemo.ejb.UserDao;
import pl.tpolgrabia.trainings.javaee.javaeedemo.entities.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class HelloController implements Serializable {
    private static final long serialVersionUID = 2780964279445984180L;
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @EJB
    private TodosDao todosDao;

    @EJB
    private UserDao userDao;

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
        logger.info("Hello submit");
        return "index";
    }

    public void toggleButtonClass() {
        this.markedAsDanger = !markedAsDanger;
        logger.info("Hello action");
    }

    @PostConstruct
    public void init() {
        this.message = "Submit me";
    }
}
