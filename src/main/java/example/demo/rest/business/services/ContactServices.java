package example.demo.rest.business.services;

import java.io.Serializable;
import java.util.List;
import example.demo.rest.business.interfaces.IContact;
import example.demo.rest.dal.ContactDAO;
import example.demo.rest.model.Contact;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ContactServices implements IContact,Serializable {
     @Inject
       private ContactDAO contactDAO;

    @Override
    public boolean create(Contact contact) {
       return  contactDAO.create(contact);
    }

   @Override
   public boolean delete(int id) {
      return contactDAO.delete(id);
   }

   @Override
   public boolean update(Contact contact) {
      return contactDAO.update(contact);
   }

   @Override
   public List<Contact> getAll(int id) {
        return contactDAO.getAll(id);
   }

    
}