package example.demo.rest.business.services;

import example.demo.rest.business.interfaces.IUser;
import example.demo.rest.dal.UserDAO;
import example.demo.rest.model.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@RequestScoped

public class UserServices implements IUser {

    @Inject
    private UserDAO userDAO;


    @Override
    public User createUser(User user) {
        // Implement validation and other business logic
        return userDAO.create(user);
    }

    @Override
    public User authenticateUser(User user) {
        // Call the authentication method of UserDAO to authenticate the user
        User authenticatedUser = userDAO.auth(user);

        if (authenticatedUser != null) {
            return authenticatedUser;
        }
        return null;
    }

    @Override
    public User getUserById(Long userId) {
        return userDAO.find(userId);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = getUserById(userId);
        if (user != null) {
            userDAO.delete(user);
        }
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }

    // @Override
    // public List<User> getAllUsers() {
    //     return userDAO.findAll();
    // }
}