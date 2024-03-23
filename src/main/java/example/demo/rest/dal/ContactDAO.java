package example.demo.rest.dal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import example.demo.rest.model.Contact;

import java.util.List;

public class ContactDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public boolean create(Contact entity) {
        try {
            entityManager.persist(entity);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Contact find(Long index) {
        return entityManager.find(Contact.class, index);
    }

    @Transactional
    public boolean delete(int index) {
        try {
            Contact contact = entityManager.find(Contact.class, index);
            if (contact != null) {
                entityManager.remove(contact);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Transactional
    public boolean update(Contact entity) {
        try {
            entityManager.merge(entity);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Contact> getAll(int iduser) {
        return entityManager.createQuery("SELECT c FROM Contact c WHERE c.id = :id", Contact.class)
                            .setParameter("iduser", iduser)
                            .getResultList();
    }

}
