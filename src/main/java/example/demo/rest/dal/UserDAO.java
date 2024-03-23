package example.demo.rest.dal;


import java.util.List;

import example.demo.rest.model.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;



@Named //makes this class injectable (tells the CDI hey this is a bean)
@RequestScoped 

@Transactional //means that the database operations performed by these methods (such as saving, updating, or deleting entities) will be wrapped in a transaction, providing ACID properties (Atomicity, Consistency, Isolation, Durability) to the operations.
public class UserDAO implements Repository<User, Long> {

    @PersistenceContext(name="contactsdb")
    private EntityManager entityManager;

    @Override
    public User create(User entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public User auth(User entity) {
        String jpql = "SELECT u FROM User u WHERE u.login = :login AND u.password = :password";

        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("login", entity.getLogin());
        query.setParameter("password", entity.getPassword());

        List<User> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public User find(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(User entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public void update(User entity) {
        entityManager.merge(entity);
    }

    // @Override
    // public List<User> findAll() {
    //     return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    // }
}

