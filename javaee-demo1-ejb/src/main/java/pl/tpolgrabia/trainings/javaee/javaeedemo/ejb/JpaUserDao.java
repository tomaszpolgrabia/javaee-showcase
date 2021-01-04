package pl.tpolgrabia.trainings.javaee.javaeedemo.ejb;

import pl.tpolgrabia.trainings.javaee.javaeedemo.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class JpaUserDao implements UserDao {
    @PersistenceContext(unitName = "my-persistence-unit")
    private EntityManager em;

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
