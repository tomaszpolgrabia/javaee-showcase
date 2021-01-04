package pl.tpolgrabia.trainings.javaee.javaeedemo.ejb;

import javax.ejb.Local;
import java.util.List;

@Local
public interface TodosDao {
    List<String> findAll();
}
