package pl.tpolgrabia.trainings.javaee.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.tpolgrabia.trainings.javaee.javaeedemo.ejb.TodosDao;
import pl.tpolgrabia.trainings.javaee.javaeedemo.ejb.UserDao;
import pl.tpolgrabia.trainings.javaee.javaeedemo.entities.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @EJB
    private TodosDao todosDao;

    @EJB
    private UserDao userDao;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getAllTodos() {
        return todosDao.findAll();
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public String handleSubmit() {
        logger.info("Hello submit");
        return "index";
    }

    public void handleSimpleAction() {
        logger.info("Hello action");
    }

    @PostConstruct
    public void init() {
        this.message = "Submit me";
    }
}
