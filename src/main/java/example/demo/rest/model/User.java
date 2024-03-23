package example.demo.rest.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.inject.Named;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Named

@Entity
@Table(name = "user")
public class User implements Serializable {


    //NOTE BIEN !!!!!!!!!!!!!!
//we impliment serializable when we want to save these objects to a file, send them over the internet, or store them in a database.
//So, when we make a class "serializable", it's like telling the computer that the objects of that class can be copied and saved for later use
//i dont think it s necessary here

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to say this is a primary key AUTO INCREMENT
    private int id;

    //****THIS PART IS  JUST FOR CREATING RELATIONSHIP BETWEEN user and contact, so you can use foreign key in contact table*/
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) 
    //each user can have one or many contacts
    //cascade means if you delete (or persist, merge) a user, his contacts will be deleted too
    private Set<Contact> contacts; //set is a collection, allows duplicate elements, no order
    // contacts {contact1, contact2, contact3 ...}

    private String login;
    private String password;
    private Boolean isAdmin;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", contacts=" + contacts + ", login=" + login + ", password=" + password
                + ", isAdmin=" + isAdmin + "]";
    }
    
}
