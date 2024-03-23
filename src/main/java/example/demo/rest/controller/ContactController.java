package example.demo.rest.controller;


import java.util.List;

import example.demo.rest.business.services.ContactServices;
import example.demo.rest.model.Contact;
import example.demo.rest.model.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/contacts")
public class ContactController {

    @Inject
       ContactServices contactServices;

    @Path("/addcontact")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean create(Contact contact){
          return contactServices.create(contact);
    }


    @Path("/deletecontact")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delete(Contact contact){
          return contactServices.delete(contact.getId());
    }


    @Path("/updatecontact")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean update(Contact contact){
          return contactServices.update(contact);
    }


    @Path("/allcontacts")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAll(User user){
          return contactServices.getAll(user.getId());
    }

}