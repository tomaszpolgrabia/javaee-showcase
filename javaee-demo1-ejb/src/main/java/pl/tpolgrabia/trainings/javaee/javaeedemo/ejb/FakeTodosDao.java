package pl.tpolgrabia.trainings.javaee.javaeedemo.ejb;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

@Stateless
public class FakeTodosDao implements TodosDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("Todo 1", "Todo 2", "Todo 3");
    }
}
