package pl.tpolgrabia.trainings.javaee.javaeedemo.ejb;

import pl.tpolgrabia.trainings.javaee.javaeedemo.entities.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserDao {
    List<User> findAll();
}
