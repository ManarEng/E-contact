package example.demo.rest.business.interfaces;

import example.demo.rest.model.Contact;
import java.util.List;

public interface IContact {

    boolean create(Contact contact);
    boolean delete(int id);
    boolean update(Contact contact);
    List<Contact> getAll(int id);
    //List<Contact> getAllContactsByUserId(Long userId);
    
}
